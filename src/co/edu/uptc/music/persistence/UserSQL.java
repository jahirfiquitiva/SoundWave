package co.edu.uptc.music.persistence;

public class UserSQL {

    public String queryUsers() {
        return "select *from users";
    }

    public String queryUser(String id) {
        return "SELECT * FROM USERS WHERE USER_ID=\'" + id + "\';";
    }

    public String insertUser(String type, String id, String name, String email, String userName,
                             String password) {

       /* return "INSERT INTO USER VALUES(\'" + id + "\', \'" + type + "\', \'" + name + "\', MD5
       (\'" +
                password + "\'));";
*/
       /* return "insert into USERS values ('" + id + "','" + type + "','" + name + "','" + email
                + "','" + userName + "','" + "\', MD5(\'" +
                password + "\'));";*/



        return "INSERT INTO USERS VALUES(\'" + type + "\', \'" + id + "\', \'" + name + "\', \'"
                + email + "\', \'" + userName + "\', MD5" + "(\'" + password + "\'));";

    }

    public String deleteUser(String id) {
        return "DROP USERS WHERE USER_ID='" + id + "';";
    }
}