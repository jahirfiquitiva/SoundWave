package co.edu.uptc.music.servlets;

import java.io.IOException;

import com.google.gson.Gson;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.GenreManager;

@WebServlet(name = "GenreServlet", urlPatterns = {"/GenreServlet"})
public class GenreServlet extends HttpServlet {

    GenreManager genreManager = new GenreManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String data = request.getParameter("data");
        int opt = Integer.parseInt(data);
        try (PrintWriter writer = response.getWriter()) {
            switch (opt) {
                default:
                case 1:
                    genreManager.loadGenres();
                    break;

            }
            if (genreManager.getList().size() > 0) {
                writer.print("{\"genres\":" + gson.toJson(genreManager.getList()) + "}");
            }
            writer.close();
        }

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        try {
            processRequest(req, resp);
        } catch (Exception ignored) {
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        try {
            processRequest(req, resp);
        } catch (Exception ignored) {
        }
    }

    @Override
    public String getServletInfo() {
        return "Genre servlet";
    }


}
