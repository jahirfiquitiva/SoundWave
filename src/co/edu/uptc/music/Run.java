package co.edu.uptc.music;

import java.sql.ResultSet;

import co.edu.uptc.music.persistence.UserDAO;

public class Run {

    private UserDAO dao;

    public Run() {
        dao = new UserDAO();
    }

    public static void main(String[] args) {
        Run r = new Run();
        r.execute();
    }

    public void execute() {
        ResultSet rs = dao.queryUsers();
        try {
            while (rs.next()) {
                String userId = rs.getString("USER_ID");
                String typeRef = rs.getString("TYPE_REF");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                System.out.println(userId + "\t" + typeRef + "\t" + username + "\t" + password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}