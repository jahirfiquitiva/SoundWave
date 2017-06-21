package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.models.Artist;
import co.edu.uptc.music.logic.models.GenreType;
import co.edu.uptc.music.logic.models.Song;
import co.edu.uptc.music.logic.models.User;
import co.edu.uptc.music.logic.models.UserType;
import co.edu.uptc.music.persistence.SongDAO;

public class SongsManager extends BaseManager<Song> {

    private UsersManager users;
    private SongDAO songDAO;

    public SongsManager() {
        this.songDAO = new SongDAO();
        this.users = new UsersManager();
        users.load();
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
        internalLoad(songDAO.querySongs());
    }

    public void loadSongsByArtist() {
        internalLoad(songDAO.querySongsByArtist());
    }

    public void loadSongsByGenre() {
        internalLoad(songDAO.querySongsByGenre());
    }

    public void loadFavorites(String userId) {
        internalLoad(songDAO.queryFavorites(userId));
    }

    public void loadSongsFromPlaylists(String userId, String listId) {
        internalLoad(songDAO.querySongsFromPlaylist(userId, listId));
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

