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

@WebServlet(name = "SongsServlet", urlPatterns = {"/SongsServlet"})
public class SongsServlet extends HttpServlet {

    SongsManager mngSong = new SongsManager();

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        try (PrintWriter writer = response.getWriter()) {
            mngSong.loadSongs();
            if (mngSong.getList().size() > 0) {
                writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");
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

    @Override
    public String getServletInfo() {
        return "Songs servlet";
    }

}
