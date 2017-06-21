package co.edu.uptc.music.persistence;

import java.sql.ResultSet;
import java.sql.Statement;

import co.edu.uptc.music.logic.models.Song;

public class SongDAO {

    private DatabaseConnection connection;
    private SongSQL songSQL;

    public SongDAO() {
        connection = new DatabaseConnection();
        songSQL = new SongSQL();
    }

    public ResultSet querySongs() {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.querySongs());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet querySongsByArtist() {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.songsByArtists());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet querySongsByGenre() {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.songsByGenre());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet querySong(String idSong) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.querySong(idSong));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void insertSong(Song song) throws Exception {
        if (connection.connectToDB()) {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate(songSQL.insertSong(song.getId(), song.getName(),
                    song.getArtist().getGenre().getName(), song.getArtist().getUsername(),
                    song.getPath()));
        }
    }

    public boolean deleteSong(String idSong) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeQuery(songSQL.deleteSong(idSong));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public ResultSet queryFavorites(String idUser) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.queryFavorites(idUser));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet queryPlaylists(String idUser) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.queryPlaylists(idUser));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet querySongsFromPlaylist(String userId, String listId) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(songSQL.querySongsFromPlaylist(userId, listId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean addSongsToPlaylist(String idList, String idSong) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate(songSQL.addSongsToPlaylist(idList, idSong));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean createNewPlaylist(String idList, String name) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate(songSQL.addNewPlaylist(idList, name));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addListToUser(String idList, String idUser) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate(songSQL.addListToUser(idList, idUser));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}