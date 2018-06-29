package co.edu.uptc.music.persistence;

public class UserSQL {

    public String queryUsers() {
        return "SELECT * FROM USERS;";
    }

    public String queryUser(String id) {
        return "SELECT * FROM USERS WHERE USER_ID=\'" + id + "\';";
    }

    public String insertUser(String type, String id, String name, String email, String userName,
                             String password) {
        return "INSERT INTO USERS VALUES(\'" + id + "\', \'" + type + "\', \'" + name + "\', \'"
                + email + "\', \'" + userName + "\', MD5" + "(\'" + password + "\'));";

    }

    public String deleteUser(String id) {
        return "DROP USERS WHERE USER_ID='" + id + "';";
    }
}