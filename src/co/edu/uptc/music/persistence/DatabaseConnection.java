package co.edu.uptc.music.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/musicplayer";
    private static final String USER = "root";
    // TODO: Quitar contraseña antes de subirlo a GitHub
    private static final String PASSWORD = "";

    private Connection connection;

    public DatabaseConnection() {
        super();
    }

    public boolean connectToDB() {
        boolean connected = false;
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connected = true;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return connected;
    }

    public void close() {
        try {
            if (connection != null) connection.close();
        } catch (Exception ignored) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

}