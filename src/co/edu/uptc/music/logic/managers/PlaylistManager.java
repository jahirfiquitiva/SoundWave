package co.edu.uptc.music.logic.managers;

import co.edu.uptc.music.logic.models.Playlist;

public class PlaylistManager extends BaseManager<Playlist> {

    public PlaylistManager() {
        super();
    }

    public boolean addPlaylist(String name, String owner) {
        return addItem(new Playlist(name, owner));
    }

    public boolean removePlaylist(String name) {
        return removeItem(findItem(name));
    }

    @Override
    public Playlist findItem(String s) {
        for (Playlist list : getList()) {
            if (list.getName().equalsIgnoreCase(s)) return list;
        }
        return null;
    }
}