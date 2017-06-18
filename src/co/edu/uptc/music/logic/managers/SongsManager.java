package co.edu.uptc.music.logic.managers;

import co.edu.uptc.music.logic.models.Song;

public class SongsManager extends BaseManager<Song> {

    public boolean addSong(String name, int length, String genre, String artist) {
        return addItem(new Song(name, length, genre, artist));
    }

    public boolean removeSong(String name) {
        return removeItem(findItem(name));
    }

    @Override
    public Song findItem(String s) {
        for (Song song : getList()) {
            if (song.getName().equalsIgnoreCase(s)) return song;
        }
        return null;
    }
}