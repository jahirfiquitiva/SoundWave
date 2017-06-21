package co.edu.uptc.music.logic.models;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.managers.BaseManager;
import co.edu.uptc.music.logic.managers.UsersManager;
import co.edu.uptc.music.persistence.SongDAO;

public class Playlist extends BaseManager<Song> {

    private SongDAO songDAO;
    private UsersManager users;
    private String id;
    private String name;

    public Playlist(String id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.users = new UsersManager();
        this.songDAO = new SongDAO();
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

    public void loadSongs() {
        internalLoad(songDAO.querySongsFromPlaylist(id));
    }

    private void internalLoad(ResultSet rs) {
        if (rs != null) {
            try {
                clearList();
                while (rs.next()) {
                    String id = rs.getString("SONG_ID");
                    String name = rs.getString("NAME");
                    String artist = rs.getString("ARTIST");
                    String genre = rs.getString("GENRE");
                    String path = rs.getString("FILE_PATH");
                    String img = rs.getString("IMG_PATH");
                    addSong(id, name, artist, genre, path, img);
                }
            } catch (Exception ignored) {
            }
        }
    }

}