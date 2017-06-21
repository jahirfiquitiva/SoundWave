package co.edu.uptc.music.logic.models;

import co.edu.uptc.music.logic.managers.BaseManager;
import co.edu.uptc.music.logic.managers.UsersManager;

public class Playlist extends BaseManager<Song> {

    private UsersManager users;
    private String id;
    private String name;

    public Playlist(String id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.users = new UsersManager();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private boolean addSong(String id, String name, String artist, String genre, String path,
                            String img) {
        User nArtist = users.findItem(artist);
        if (nArtist != null && nArtist.getType() == UserType.ARTIST) {
            Artist art = new Artist(nArtist.getId(), nArtist.getType(),
                    nArtist.getName(), nArtist.getEmail(), nArtist.getUsername(),
                    nArtist.getPassword(), GenreType.getGenreForString(genre), img);
            return addItem(new Song(id, name, art, path, img));
        }
        return false;
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