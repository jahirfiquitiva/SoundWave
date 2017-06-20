package co.edu.uptc.music.logic.models;

public class Song {

    private String id;
    private String name;
    private Artist artist;
    private String path;
    private String img;

    public Song(String id, String name, Artist artist, String path, String img) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.path = path;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
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
                ", path='" + path + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}