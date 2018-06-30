package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.SongsManager
import co.soundwave.managers.UsersManager
import co.soundwave.models.Song
import com.google.gson.Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "PlayerServlet", urlPatterns = ["/PlayerServlet"])
class PlayerServlet : BaseServlet() {
    
    private val mng = SongsManager()
    private val users = UsersManager()
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        val gson = Gson()
        val data = request.getParameter("data")
        val currentSongId = Integer.parseInt(request.getParameter("current"))
        
        val username = request.getParameter("username")
        val playlistId = Integer.parseInt(request.getParameter("listId"))
        val opc = Integer.parseInt(data)
        ignore {
            response.writer.use { writer ->
                var nSong: Song? = null
                val songs = mng.getSongsInPlaylist(playlistId)
                for (i in songs.indices) {
                    if (songs[i].id == currentSongId) {
                        ignore {
                            if (opc == 0) {
                                nSong = songs[i - 1]
                            } else if (opc == 1) {
                                nSong = songs[i + 1]
                            }
                        }
                        if (nSong != null) break
                    }
                }
                if (nSong != null) {
                    writer.write(gson.toJson(nSong))
                }
                writer.close()
            }
        }
    }
    
    override fun getServletInfo(): String = "Player Servlet"
}