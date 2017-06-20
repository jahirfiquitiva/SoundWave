package co.edu.uptc.music.servlets;

import java.io.IOException;

import com.google.gson.Gson;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.uptc.music.logic.managers.GenresManager;

@WebServlet(name = "GenresServlet", urlPatterns = {"/GenresServlet"})
public class GenresServlet extends HttpServlet {

    GenresManager genresManager = new GenresManager();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String data = request.getParameter("data");
        try (PrintWriter writer = response.getWriter()) {
            genresManager.loadGenres();
            if (genresManager.getList().size() > 0) {
                writer.print("{\"genres\":" + gson.toJson(genresManager.getList()) + "}");
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
