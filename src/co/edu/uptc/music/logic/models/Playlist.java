package co.edu.uptc.music.logic.models;

import co.edu.uptc.music.logic.managers.BaseManager;

public class Playlist extends BaseManager<Song> {

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

    @Override
    public Song findItem(String s) {
        for (Song song : getList()) {
            if (song.getName().equalsIgnoreCase(s)) return song;
        }
        return null;
    }
}