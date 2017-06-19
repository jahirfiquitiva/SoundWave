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

    public ResultSet QuerysongArtis() {
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

    public ResultSet QuerysongGender() {
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
                    String.valueOf(song.getLength()), song.getGenre(), song.getArtist(), song
                            .getPath()));
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

}