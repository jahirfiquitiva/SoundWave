package co.edu.uptc.music.logic;

import java.sql.ResultSet;
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
        try {
            if (users != null) users.clear();
            else users = new ArrayList<>();
            while (rs.next()) {
                String userId = rs.getString("USER_ID");
                String typeRef = rs.getString("TYPE_REF");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                users.add(new User(userId, UserType.getUserForString(typeRef), username, password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findUser(String name) {
        if (users == null) return null;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

}