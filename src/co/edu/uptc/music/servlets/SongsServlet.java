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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String data = request.getParameter("data");

        int opc = Integer.parseInt(data);

        //System.out.print("pos"+Integer.parseInt(login));

        try (PrintWriter writer = response.getWriter()) {

            System.out.print("entrando al servlet" + mngSong.getList().size() + data);

            if (opc == 1) {
                mngSong.loadSongs();


                if (mngSong.getList().size() > 0) {
                    writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");
                }
            } else if (opc == 2) {

                mngSong.songArtist();
                System.out.print("ENTRANDO");
                if (mngSong.getList().size() > 0) {
                    writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");
                }


            } else if (opc == 3) {

            }


            mngSong.songGender();

            if (mngSong.getList().size() > 0) {
                writer.print("{\"songs\":" + gson.toJson(mngSong.getList()) + "}");
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
