package co.edu.uptc.music.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.SongsManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.logic.models.Artist;
import co.edu.uptc.music.logic.models.Song;

@WebServlet(name = "SongsServlet", urlPatterns = {"/SongsServlet"})
public class SongsServlet extends HttpServlet {

    SongsManager mngSong = new SongsManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        String data = request.getParameter("data");
        int opc = Integer.parseInt(data);
        try (PrintWriter writer = response.getWriter()) {
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
            if (opc == 4) {
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
            } else if (opc == 5) {
                ArrayList<Song> results = new ArrayList<>();
                for (Song song : mngSong.getList()) {
                    String searching = request.getParameter("search");
                    if (searching != null && searching.length() > 0) {
                        if (song.getName().toLowerCase()
                                .contains(searching.toLowerCase())) {
                            results.add(song);
                        }
                    }
                }
                if (results.size() > 0) {
                    writer.print("{\"songs\":" + gson.toJson(results) + "}");
                }
            } else {
                if (mngSong.getList().size() > 0) {
                    writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");
                }
            }
            writer.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ignored) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Songs servlet";
    }

}
