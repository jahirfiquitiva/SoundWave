package co.edu.uptc.music.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.PlaylistManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.persistence.SongSQL;

@WebServlet(name = "PlaylistsServlet")
public class PlaylistsServlet extends HttpServlet {

    PlaylistManager playlist = new PlaylistManager();
    SongSQL songSQL = new SongSQL();
    UsersManager user = new UsersManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        System.out.print("entrando");
        int opc = Integer.valueOf(request.getParameter("data"));


        try (PrintWriter writer = response.getWriter()) {

            if (opc == 1) {
                user.load();
                String songId = request.getParameter("songId");
                String username = request.getParameter("username");
                String id = user.findItem(username).getId();
                songSQL.addListToUser("PL000", id);
                songSQL.addSongsToPlaylist("PL000", "songId");
                writer.print("{\"code\": 4}");
            } else if (opc == 2) {

                playlist.getList();

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