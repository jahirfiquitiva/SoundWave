package co.soundwave.servlets

import co.soundwave.extensions.ignore
import co.soundwave.managers.PlaylistsManager
import co.soundwave.managers.SongsManager
import co.soundwave.managers.UsersManager
import com.google.gson.Gson
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "PlaylistsServlet", urlPatterns = ["/PlaylistsServlet"])
class PlaylistsServlet : BaseServlet() {
    
    private val users = UsersManager()
    private val songsManager = SongsManager()
    private val playlists = PlaylistsManager()
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        val gson = Gson()
        val opc = Integer.valueOf(request.getParameter("data"))
        users.load()
        ignore {
            response.writer.use { writer ->
                val username = request.getParameter("username")
                val u = users.findItem(username)
                if (u != null) {
                    playlists.load(u.id)
                    if (opc == 1) {
                        val songId = Integer.parseInt(request.getParameter("songId"))
                        playlists.createFavsPlaylist(u.id)
                        if (playlists.addSongToFavorites(songId)) {
                            writer.print("{\"code\": 1}")
                        }
                    } else if (opc == 2) {
                        val favs = playlists.getList().firstOrNull { it.name == "Favorites" }
                        favs?.let {
                            writer.print(
                                "{\"songs\":" + gson.toJson(
                                    songsManager.getSongsInPlaylist(it.id)) + "}")
                        } ?: {
                            writer.print(
                                "{\"songs\": []}")
                        }()
                    } else if (opc == 3) {
                        if (playlists.getList().isNotEmpty()) {
                            writer.print("{\"lists\":" + gson.toJson(playlists.getList()) + "}")
                        }
                    } else if (opc == 4) {
                        println("Opción 4 ... kejesto?")
                        /* TODO: Check
                    if (u.getType() == UserType.ADMIN || u.getType() == UserType.ARTIST) {
                        writer.print("{\"code\": 1}");
                    }
                    */
                    } else if (opc == 5) {
                        if (playlists.createNewPlaylist(request.getParameter("listid"), u.id)) {
                            writer.print("{\"code\": 1}")
                        }
                    } else if (opc == 6) {
                        val songId = Integer.parseInt(request.getParameter("songid"))
                        val list = playlists.findItem(request.getParameter("listid"))
                        if (list != null) {
                            playlists.addSongToPlaylist(list.id, songId)
                            writer.print("{\"code\": 1}")
                        }
                    } else if (opc == 7) {
                        val list =
                            playlists.findItem(Integer.parseInt(request.getParameter("listid")))
                        if (list != null) {
                            val songsFromPlaylist = songsManager.getSongsInPlaylist(list.id)
                            if (songsFromPlaylist.size > 0) {
                                writer.print("{\"songs\":" + gson.toJson(songsFromPlaylist) + "}")
                            }
                        }
                    } else if (opc == 8) {
                        val list =
                            playlists.findItem(Integer.parseInt(request.getParameter("listid")))
                        if (list != null && playlists.delete(list.id)) {
                            writer.print("{\"code\": 1}")
                        }
                    }
                }
                writer.close()
            }
        }
    }
    
    override fun getServletInfo(): String = "Playlists Servlet"
}