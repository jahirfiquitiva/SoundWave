package co.edu.uptc.music.logic.models;

public class User {
    private String id;
    private UserType type;
    private String name;
    private String email;
    private String username;
    private String password;

    public User(String id, UserType type, String name, String email, String username,
                String password) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean validateUser(String password) {
        return password.equalsIgnoreCase(this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}