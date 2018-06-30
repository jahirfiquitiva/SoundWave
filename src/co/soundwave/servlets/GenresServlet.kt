package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.GenresManager
import com.google.gson.Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "GenresServlet", urlPatterns = ["/GenresServlet"])
class GenresServlet : BaseServlet() {
    
    private val genresManager = GenresManager()
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        ignore {
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            val gson = Gson()
            val data = request.getParameter("data")
            response.writer.use { writer ->
                genresManager.load()
                if (genresManager.getList().size > 0) {
                    writer.print("{\"genres\":" + gson.toJson(genresManager.getList()) + "}")
                }
                writer.close()
            }
        }
    }
    
    override fun getServletInfo(): String = "Genre servlet"
}
