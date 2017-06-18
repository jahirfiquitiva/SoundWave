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
                    String typeRef = rs.getString("TYPE_REF");
                    String username = rs.getString("USERNAME");
                    String email = rs.getString("EMAIL");
                    String password = rs.getString("PASSWORD");
                    addItem(new User(userId, UserType.getUserForString(typeRef), username, email,
                            password));
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public User findItem(String name) {
        for (User user : getList()) {
            if (user.getName().equalsIgnoreCase(name)) return user;
        }
        return null;
    }

    public boolean addNewUser(String name, String email, String password, String type) {
        if (findItem(name) != null) return false;
        DecimalFormat formatter = new DecimalFormat("00");
        String num = formatter.format(getListSize() + 1);
        try {
            dao.insertUser(new User(("USR" + num), UserType.getUserForString(type), name, email,
                    password));
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

}