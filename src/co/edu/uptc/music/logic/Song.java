package co.edu.uptc.music.logic;

public class Song {
    private String nameSong;
    private int duration;
    private String genre;
    private String artist;

    public Song(String nameSong, int duration, String genre, String artist) {
        this.nameSong = nameSong;
        this.duration = duration;
        this.genre = genre;
        this.artist = artist;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "nameSong='" + nameSong + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
