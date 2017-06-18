package co.edu.uptc.music.logic.models;

public class User {
    private String id;
    private UserType type;
    private String name;
    private String email;
    private String password;
    private String genre;

    public User(String id, UserType type, String name, String email, String password) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String id, UserType type, String name, String email, String password,
                String genre) {
        this(id, type, name, email, password);
        this.genre = genre;
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

    public String getPassword() {
        return password;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isArtist() {
        return genre != null && genre.length() > 0;
    }

    public boolean validateUser(String password) {
        System.out.println("Expected: " + this.password + " - Result: " + password);
        return password.equalsIgnoreCase(this.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}