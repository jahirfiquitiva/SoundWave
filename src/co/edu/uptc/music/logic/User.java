package co.edu.uptc.music.logic;

public class User {
    private String id;
    private UserType type;
    private String name;
    private String password;

    public User(String id, UserType type, String name, String password) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean validateUser(String password) {
        return password.equals(this.password);
    }
}