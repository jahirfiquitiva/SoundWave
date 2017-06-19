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

@WebServlet(name = "SongsServlet")

public class SongsServlet extends HttpServlet {

    SongsManager mngSong = new SongsManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        mngSong.loadSongs();

        try (PrintWriter out = response.getWriter()) {

            if (mngSong.getList().size() > 0) {

                out.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");

            }


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
