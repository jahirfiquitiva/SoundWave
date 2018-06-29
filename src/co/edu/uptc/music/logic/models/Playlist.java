package co.edu.uptc.music.logic.models;

public class Playlist {

    private String id;
    private String name;

    public Playlist(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}