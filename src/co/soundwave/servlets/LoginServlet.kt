package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.ArtistsManager
import co.soundwave.managers.UsersManager
import com.google.gson.Gson
import java.security.MessageDigest
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.xml.bind.DatatypeConverter

@WebServlet(name = "LoginServlet", urlPatterns = ["/LoginServlet"])
class LoginServlet : BaseServlet() {
    
    private val usersManager = UsersManager()
    private val artistsManager = ArtistsManager()
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        ignore {
            usersManager.load()
            artistsManager.load()
            
            val gson = Gson()
            response.writer.use { writer ->
                val nick = request.getParameter("username")
                val pass = request.getParameter("password")
                val login = request.getParameter("login")
                
                val loginValue = Integer.parseInt(login)
                
                if (loginValue == 1) {
                    val user = usersManager.findItem(nick)
                    
                    val digest = MessageDigest.getInstance("MD5")
                    digest.update(pass.toByteArray())
                    val chainAux = digest.digest()
                    val myHash = DatatypeConverter.printHexBinary(chainAux)
                    val inputPassword = try {
                        myHash.substring(0, 40)
                    } catch (e: Exception) {
                        myHash
                    }
                    
                    if (user != null) {
                        if (user.validate(inputPassword)) {
                            val aux = gson.toJson(user)
                            val sb = StringBuilder()
                            sb.append("{\"code\":2,")
                            sb.append(aux, 1, aux.length - 1)
                            val usersList = gson.toJson(usersManager.getList())
                            sb.append(",\"list\": ").append(usersList)
                            sb.append("}")
                            writer.print(sb.toString())
                        } else {
                            writer.print("{\"code\":1,\"error\":\"La contraseña es incorrecta.\"}")
                        }
                    } else {
                        val artist = artistsManager.findItem(nick)
                        
                        if (artist != null) {
                            if (artist.validate(inputPassword)) {
                                val aux = gson.toJson(artist)
                                val sb = StringBuilder()
                                sb.append("{\"code\":4,")
                                sb.append(aux, 1, aux.length - 1)
                                val usersList = gson.toJson(usersManager.getList())
                                sb.append(",\"list\": ").append(usersList)
                                sb.append("}")
                                writer.print(sb.toString())
                            } else {
                                writer.print(
                                    "{\"code\":1,\"error\":\"La contraseña es incorrecta.\"}")
                            }
                        } else {
                            writer.print(
                                "{\"code\":0,\"error\":\"El usuario no se encuentra " + "registrado.\"}")
                        }
                    }
                } else if (loginValue == 2) {
                    val doc = Integer.parseInt(request.getParameter("doc"))
                    val name = request.getParameter("name")
                    val lastName = request.getParameter("lastName")
                    val age = Integer.parseInt(request.getParameter("age"))
                    val email = request.getParameter("email")
                    // if (usersManager.addNewUser(fullname, email, name, pass)) {
                    if (usersManager.addNewUser(doc, name, lastName, age, nick, email, pass)) {
                        writer.print("{\"code\": 4}")
                    } else {
                        writer.print(
                            "{\"code\": 3, \"error\": \"El usuario ya se encuentra " + "registrado en la base de datos\"}")
                    }
                }
                writer.close()
            }
        }
    }
    
    override fun getServletInfo(): String = "Login servlet"
}