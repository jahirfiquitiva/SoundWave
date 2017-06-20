package co.edu.uptc.music.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.PlayListManager;
import co.edu.uptc.music.logic.managers.SongsManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.logic.models.User;
import co.edu.uptc.music.persistence.SongDAO;

@WebServlet(name = "PlaylistsServlet", urlPatterns = {"/PlaylistsServlet"})
public class PlaylistsServlet extends HttpServlet {

    private UsersManager users = new UsersManager();
    private SongsManager playlist = new SongsManager();
    private PlayListManager list=new PlayListManager();
    private SongDAO dao = new SongDAO();

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
                String id = u.getId();
                if (opc == 1) {
                    String songId = request.getParameter("songId");
                    dao.addListToUser("FAVS", id);
                    dao.addSongsToPlaylist("FAVS", songId);
                    writer.print("{\"code\": 1}");
                } else if (opc == 2) {
                    playlist.loadFavorites(id);
                    playlist.getList();
                    if (playlist.getList().size() > 0) {
                        writer.print("{\"songs\":" + gson.toJson(playlist.getList()) + "}");
                    }
                } else if (opc == 3) {

                    list.load(u.getId());
                    list.getList();
                    if (list.getList().size() > 0) {
                        writer.print( gson.toJson(list.getList()));
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