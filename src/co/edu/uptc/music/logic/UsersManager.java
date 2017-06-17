package co.edu.uptc.music.logic;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import co.edu.uptc.music.persistence.UserDAO;

public class UsersManager {

    private ArrayList<User> users;
    private UserDAO dao;

    public UsersManager() {
        this.dao = new UserDAO();
        this.users = new ArrayList<>();
    }

    public void load() {
        ResultSet rs = dao.queryUsers();
        if (rs != null) {
            try {
                if (users != null) {
                    users.clear();
                } else {
                    this.users = new ArrayList<>();
                }
                while (rs.next()) {
                    String userId = rs.getString("USER_ID");
                    String typeRef = rs.getString("TYPE_REF");
                    String username = rs.getString("USERNAME");
                    String password = rs.getString("PASSWORD");
                    users.add(new User(userId, UserType.getUserForString(typeRef), username,
                            password));
                }
            } catch (Exception ignored) {
            }
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUser(String name) {
        if (users == null || users.isEmpty()) return null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public boolean addUser(String name, String password, String type) {
        if (findUser(name) != null) return false;
        DecimalFormat formatter = new DecimalFormat("00");
        String num = formatter.format((users != null ? users.size() : 0) + 1);
        try {
            dao.insertUser(new User(("USR" + num), UserType.getUserForString(type), name,
                    password));
            return true;
        } catch (Exception ignored) {
        }
        return false;
    }

}