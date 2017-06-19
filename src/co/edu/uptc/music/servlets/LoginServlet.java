package co.edu.uptc.music.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.logic.models.User;
import co.edu.uptc.music.logic.models.UserType;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UsersManager usersManager = new UsersManager();

    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            usersManager.load();
            Gson gson = new Gson();
            try (PrintWriter out = response.getWriter()) {
                String name = request.getParameter("username");
                String email = request.getParameter("email");
                String pass = request.getParameter("password");
                String login = request.getParameter("login");
                int loginValue = Integer.parseInt(login);
                if (loginValue == 1) {
                    User user = usersManager.findItem(name);
                    if (user != null) {
                        MessageDigest digest = MessageDigest.getInstance("MD5");
                        digest.update(pass.getBytes());
                        byte[] chainAux = digest.digest();
                        String myHash = DatatypeConverter.printHexBinary(chainAux);
                        if (user.validateUser(myHash)) {
                            String aux = gson.toJson(user);
                            StringBuilder sb = new StringBuilder();
                            sb.append("{\"code\":2,");
                            sb.append(aux.substring(1, aux.length() - 1));
                            if (user.getType() == UserType.ADMIN) {
                                String usersList = gson.toJson(usersManager.getList());
                                sb.append(",\"list\": ").append(usersList);
                            }
                            sb.append("}");
                            out.println(sb.toString());
                        } else {
                            out.println("{\"code\":1,\"error\":\"User exists but password is " +
                                    "incorrect.\"}");
                        }
                    } else {
                        out.println("{\"code\":0,\"error\":\"User not found.\"}");
                    }
                } else if (loginValue == 2) {
                    String type = request.getParameter("type");
                    if (usersManager.addNewUser(name, email, pass, type)) {
                        usersManager.load();
                        out.println("{\"code\": 4, \"list\": " +
                                gson.toJson(usersManager.getList()) + "}");
                    } else {
                        out.println("{\"code\": 3, \"error\": \"El usuario ya se encuentra " +
                                "registrado en la base de datos\"}");
                    }
                }
                out.close();
            } catch (Exception ignored) {
            }
        } catch (Exception ignored) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        // super.doGet(req, resp);
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        // super.doPost(req, resp);
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }

}