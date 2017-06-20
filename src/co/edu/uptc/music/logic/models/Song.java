package co.edu.uptc.music.logic.models;

public class Song {

    private String id;
    private String name;
    private String artist;
    private Genre genre;
    private int length;
    private String path;
    private String img;

    public Song(String id, String name, String artist, Genre genre, int length, String path,
                String img) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
        this.path = path;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public String getReadableLength() {
        return String.format("%02d:%02d", getLength() / 60, getLength() % 60);
    }

    public String getPath() {
        return path;
    }

    public String getImg() {
        return img;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length +
                ", path='" + path + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}