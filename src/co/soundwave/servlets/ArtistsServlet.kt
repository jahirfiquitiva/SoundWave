package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.ArtistsManager
import com.google.gson.Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "ArtistsServlet", urlPatterns = ["/ArtistsServlet"])
class ArtistsServlet : BaseServlet(){

    private val artistsManager = ArtistsManager()

    override fun processRequest(request: HttpServletRequest, response: HttpServletResponse, type: Type) {
        // TODO

        ignore {
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            val gson = Gson()
            val data = request.getParameter("data")
            response.writer.use { writer -> artistsManager.load()
                if (artistsManager.getList().size > 0) {
                    writer.print("{\"artist\":" + gson.toJson(artistsManager.getList()) + "}")
                }
                writer.close()
            }
        }
    }

    override fun getServletInfo(): String = "Artists servlet"

        }



