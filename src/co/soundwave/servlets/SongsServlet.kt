package co.soundwave.servlets

import co.soundwave.managers.SongsManager
import co.soundwave.models.Song
import com.google.gson.Gson
import java.util.ArrayList
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "SongsServlet", urlPatterns = ["/SongsServlet"])
class SongsServlet : BaseServlet() {
    
    private var mngSong = SongsManager()
    
    override fun processRequest(
        request: HttpServletRequest,
        response: HttpServletResponse,
        type: Type
                               ) {
        response.contentType = "application/json"
        response.characterEncoding = "UTF-8"
        
        val gson = Gson()
        val data = request.getParameter("data")
        val opc = Integer.parseInt(data)
        response.writer.use { writer ->
            /* TODO: Load and sort songs
            switch (opc) {
                case 2:
                case 4:
                    mngSong.loadSongsByArtist();
                    break;
                case 3:
                    mngSong.loadSongsByGenre();
                    break;
                case 1:
                default:
                    mngSong.loadSongs();
                    break;
            }
            */
            mngSong.load()
            if (opc == 4) {
                /* TODO: Move somewhere else
                UsersManager usrMan = new UsersManager();
                usrMan.load();
                ArrayList<Artist> artists = new ArrayList<>();
                ArrayList<Song> songs = mngSong.getList();
                for (Song song : songs) {
                    Artist art = song.getArtist();
                    if (!(artists.contains(art))) {
                        artists.add(art);
                    }
                }
                if (artists.size() > 0) {
                    writer.print("{\"artists\":" + gson.toJson(artists) + "}");
                }
                */
            } else if (opc == 5) {
                val results = ArrayList<Song>()
                for (song in mngSong.getList()) {
                    val searching = request.getParameter("search")
                    if (searching != null && searching.length > 0) {
                        if (song.name.toLowerCase()
                                .contains(searching.toLowerCase())) {
                            results.add(song)
                        }
                    }
                }
                if (results.size > 0) {
                    writer.print("{\"songs\":" + gson.toJson(results) + "}")
                }
            } else {
                if (mngSong.getList().size > 0) {
                    writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}")
                }
            }
            writer.close()
        }
    }
    
    override fun getServletInfo(): String = "Songs servlet"
}