package co.edu.uptc.music.logic.models;

public class Artist extends User {

    private GenreType genre;
    private String img;

    public Artist(String id, UserType type, String name, String email, String username, String
            password, GenreType genre, String img) {
        super(id, type, name, email, username, password);
        this.genre = genre;
        this.img = img;
    }

    public GenreType getGenre() {
        return genre;
    }

    public String getImg() {
        return img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return getName().equals(artist.getName());
    }

}