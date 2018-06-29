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

import co.edu.uptc.music.logic.managers.PlaylistsManager;
import co.edu.uptc.music.logic.managers.SongsManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.logic.models.Playlist;
import co.edu.uptc.music.logic.models.Song;
import co.edu.uptc.music.logic.models.User;
import co.edu.uptc.music.logic.models.UserType;

@WebServlet(name = "PlaylistsServlet", urlPatterns = {"/PlaylistsServlet"})
public class PlaylistsServlet extends HttpServlet {

    private UsersManager users = new UsersManager();
    private SongsManager songsManager = new SongsManager();
    private PlaylistsManager playlists = new PlaylistsManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        int opc = Integer.valueOf(request.getParameter("data"));
        users.load();
        try (PrintWriter writer = response.getWriter()) {
            String username = request.getParameter("username");
            User u = users.findItem(username);
            if (u != null) {
                if (opc == 1) {
                    String songId = request.getParameter("songId");
                    playlists.createFavsPlaylist(u.getId());
                    if (playlists.addSongsToPlaylist("F" + u.getId().substring(1), songId)) {
                        writer.print("{\"code\": 1}");
                    }
                } else if (opc == 2) {
                    songsManager.loadFavorites(u.getId());
                    ArrayList<Song> favorites = songsManager.getList();
                    if (favorites.size() > 0) {
                        writer.print("{\"songs\":" + gson.toJson(favorites) + "}");
                    }
                } else if (opc == 3) {
                    playlists.load(u.getId());
                    if (playlists.getList().size() > 0) {
                        writer.print("{\"lists\":" + gson.toJson(playlists.getList()) + "}");
                    }
                } else if (opc == 4) {
                    if (u.getType() == UserType.ADMIN || u.getType() == UserType.ARTIST) {
                        writer.print("{\"code\": 1}");
                    }
                } else if (opc == 5) {
                    if (playlists.createNewPlaylist(request.getParameter("listid"), u.getId())) {
                        writer.print("{\"code\": 1}");
                    }
                } else if (opc == 6) {
                    playlists.load(u.getId());
                    String listname = request.getParameter("listid");
                    Playlist target = null;
                    for (Playlist p : playlists.getList()) {
                        if (p.getId().equalsIgnoreCase(listname)) target = p;
                    }
                    if (target != null) {
                        playlists.addSongsToPlaylist(target.getId(),
                                request.getParameter("songid"));
                        writer.print("{\"code\": 1}");
                    }
                } else if (opc == 7) {
                    String listname = request.getParameter("listid");
                    songsManager.loadSongsFromPlaylists(u.getId(), listname);
                    ArrayList<Song> songsFromPlaylist = songsManager.getList();
                    if (songsFromPlaylist.size() > 0) {
                        writer.print("{\"songs\":" + gson.toJson(songsFromPlaylist) + "}");
                    }
                }
            }
            writer.close();
        } catch (Exception ignored) {
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
}