package co.edu.uptc.music.logic.models;

import java.util.ArrayList;

import co.edu.uptc.music.logic.managers.BaseManager;

public class Playlist extends BaseManager<Playlist> {

    private String id;
    private String ownerName;
    private ArrayList<Song> songs;

    public Playlist(String id, String ownerName) {
        this.id = id;
        this.ownerName = ownerName;
        this.songs = new ArrayList<>();
    }



    public String getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    /*public void addSong(Song song) {
        addItem(song);
    }*/

    public void removeSong(String name) {
        removeItem(findItem(name));
    }

    public int getLength() {
        int length = 0;
        for (Song s : songs) {
            length += s.getLength();
        }
        return length;
    }

    @Override
    public Playlist findItem(String s) {
        return null;
    }

    /*@Override
    public Song findItem(String s) {
        for (Song song : getList()) {
            if (song.getName().equalsIgnoreCase(s)) return song;
        }
        return null;
    }*/
}