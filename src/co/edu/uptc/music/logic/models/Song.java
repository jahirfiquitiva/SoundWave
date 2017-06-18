package co.edu.uptc.music.logic.models;

public class Song {
    private String name;
    private int length;
    private String genre;
    private String artist;

    public Song(String name, int length, String genre, String artist) {
        this.name = name;
        this.length = length;
        this.genre = genre;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
