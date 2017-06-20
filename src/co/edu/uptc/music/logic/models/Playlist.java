package co.edu.uptc.music.logic.models;

import java.util.ArrayList;

import co.edu.uptc.music.logic.managers.BaseManager;

public class Playlist extends BaseManager<Song> {

    private String name;
    private String ownerName;
    private ArrayList<Song> songs;

    public Playlist(String name, String ownerName) {
        this.name = name;
        this.ownerName = ownerName;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void addSong(Song song) {
        addItem(song);
    }

    public void removeSong(String name) {
        removeItem(findItem(name));
    }

    @Override
    public Song findItem(String s) {
        for (Song song : getList()) {
            if (song.getName().equalsIgnoreCase(s)) return song;
        }
        return null;
    }
}