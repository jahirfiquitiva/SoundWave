package co.edu.uptc.music.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        // response.setContentType("text/xml");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder();
        try (PrintWriter out = response.getWriter()) {
            String auxValue = request.getParameter("ip");

            /*
            IPAddress address = new IPAddress();

            sb.append("{\n");
            sb.append("\t\"code\": ");
            try {
                address.setIP(auxValue);
                sb.append("0,\n");
                sb.append("\t\"class\": \"").append(address.getNetworkClass()).append("\",\n");
                sb.append("\t\"binary\": \"").append(address.getBinaryAddress()).append("\",\n");
                sb.append("\t\"mask\": \"").append(address.getNetworkMask()).append("\",\n");
                sb.append("\t\"subnet\": \"").append(address.getSubnet()).append("\",\n");
                sb.append("\t\"hosts\": ").append(address.getHosts()).append("\n");
            } catch (Exception e) {
                sb.append("1,\n");
                sb.append("\t\"error\": \"").append(e.getMessage() != null ? e.getMessage() :
                        "Error").append("\"\n");
            }*/

            /*
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            sb.append("<results>\n");
            sb.append("<code>0</code>\n");
            sb.append("<cont>").append(auxValue).append("</cont>\n");
            sb.append("</results>");
            */
            // sb.append("\t\"results\": \"" + auxValue + "\"\n");
            sb.append("}");
            /*
            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
            out.println(sb.toString());
            out.close();
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