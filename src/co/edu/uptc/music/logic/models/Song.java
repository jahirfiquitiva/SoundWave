package co.edu.uptc.music.logic.models;

public class Song {

    private String id;
    private String name;
    private String artist;
    private String genre;
    private int length;
    private String path;

    public Song(String id, String name, String artist, String genre, int length, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
        this.path = path;
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

    public String getGenre() {
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

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length +
                ", path='" + path + '\'' +
                '}';
    }
}