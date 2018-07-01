package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.AlbumsManager
import com.google.gson.Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "AlbumsServlet", urlPatterns = ["/AlbumsServlet"])
class AlbumsServlet : BaseServlet() {

    private val albumManager = AlbumsManager()

    override fun processRequest(request: HttpServletRequest, response: HttpServletResponse, type: Type) {
        ignore {
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            val gson = Gson()
            val data = request.getParameter("data")
            response.writer.use { writer ->
                albumManager.load()
                if (albumManager.getList().size > 0) {
                    writer.print("{\"albums\":" + gson.toJson(albumManager.getList()) + "}")
                }
                writer.close()
            }
        }
    }

    override fun getServletInfo(): String = "Albums servlet"
}