package co.edu.uptc.music.persistence;

import java.sql.ResultSet;
import java.sql.Statement;

import co.edu.uptc.music.logic.models.User;

// DAO: Data Access Object
public class UserDAO {

    private DatabaseConnection connection;
    private UserSQL sqlUser;

    public UserDAO() {
        connection = new DatabaseConnection();
        sqlUser = new UserSQL();
    }

    public ResultSet queryUsers() {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(sqlUser.queryUsers());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet queryUser(String id) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(sqlUser.queryUser(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean insertUser(User user) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate(sqlUser.insertUser(user.getId(), user.getType().getName(),
                        user.getName(), user.getEmail(), user.getUsername(), user.getPassword()));
                return true;
            } catch (Exception ignored) {
                return false;
            }
        }
        return false;
    }

    public boolean deleteUser(String id) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeQuery(sqlUser.deleteUser(id));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }




}