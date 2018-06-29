package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;
import java.text.DecimalFormat;

import co.edu.uptc.music.logic.models.User;
import co.edu.uptc.music.logic.models.UserType;
import co.edu.uptc.music.persistence.UserDAO;

public class UsersManager extends BaseManager<User> {

    private UserDAO dao;

    public UsersManager() {
        super();
        this.dao = new UserDAO();
    }

    public void load() {
        ResultSet rs = dao.queryUsers();
        if (rs != null) {
            try {
                clearList();
                while (rs.next()) {
                    String userId = rs.getString("USER_ID");
                    String typeRef = rs.getString("TYPE");
                    String name = rs.getString("NAME");
                    String email = rs.getString("EMAIL");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    addItem(new User(userId, UserType.getUserForString(typeRef), name, email,
                            username, password));
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public User findItem(String name) {
        for (User user : getList()) {
            if (user.getUsername().equalsIgnoreCase(name) || user.getEmail().equalsIgnoreCase(name))
                return user;
        }
        return null;
    }


    public boolean addNewUser(String name, String email, String username, String password) {
        if (findItem(username) != null) return false;
        if (findItem(email) != null) return false;
        DecimalFormat formatter = new DecimalFormat("0000");
        String num = formatter.format(getListSize() + 1);
        try {
            return dao.insertUser(new User(("U" + num), UserType.NORMAL, name,
                    email, username, password));
        } catch (Exception ignored) {
        }
        return false;
    }

}