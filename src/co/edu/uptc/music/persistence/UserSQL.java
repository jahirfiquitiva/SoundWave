package co.edu.uptc.music.persistence;

public class UserSQL {
    public String queryUsers() {
        return "SELECT * FROM USER;";
    }

    public String queryUser(String id) {
        return "SELECT * FROM USER WHERE USER_ID=\'" + id + "\';";
    }

    public String insertUser(String id, String type, String name, String password) {
        return "INSERT INTO USER VALUES(\'" + id + "\', \'" + type + "\', \'" + name + "\', \'" +
                password + "\');";
    }

    public String deleteUser(String id) {
        return "DROP USER WHERE USER_ID='" + id + "'";
    }
}