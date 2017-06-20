package co.edu.uptc.music.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.SongsManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.persistence.SongDAO;

@WebServlet(name = "PlaylistsServlet", urlPatterns = {"/PlaylistsServlet"})
public class PlaylistsServlet extends HttpServlet {

    SongsManager playlist = new SongsManager();
    SongDAO dao = new SongDAO();
    UsersManager user = new UsersManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        int opc = Integer.valueOf(request.getParameter("data"));

        //System.out.print("entrando playlists"+opc);
        try (PrintWriter writer = response.getWriter()) {
            String username = request.getParameter("username");
            String id = user.findItem(username).getId();
            if (opc == 1) {
                user.load();
                String songId = request.getParameter("songId");
                System.out.println("nameUser" + username);
                System.out.println("idUser" + id);
                dao.addListToUser("FAVS", id);
                dao.addSongsToPlaylist("FAVS", songId);
                System.out.print("añadido con exito");
                writer.print("{\"code\": 4}");

            } else if (opc == 2) {
                playlist.loadFavorites(id);
                playlist.getList();
                System.out.print("tamaño lista" + playlist.getList().size());
                if (playlist.getList().size() > 0) {
                    writer.print("{\"songs\":" + gson.toJson(playlist.getList()) + "}");
                }
            }
            //if (playlist.getList().size() > 0) {
            // writer.print("{\"songs\":" + gson.toJson(playlist.getList()) + "}");

            //}

            // id list PL000
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