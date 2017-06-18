package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.models.Song;
import co.edu.uptc.music.persistence.SongDAO;

public class SongsManager extends BaseManager<Song> {

    private SongDAO songDAO;

    public SongsManager() {

        songDAO = new SongDAO();

    }

    public boolean addSong(String idSong, String name, int length, String genre, String artist,
                           String filePath) {
        return addItem(new Song(idSong, name, length, genre, artist, filePath));
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


    public void loadSong() {
        ResultSet rs = songDAO.querySongs();


        if (rs != null) {

        }

        try {

            while (rs.next()) {

                String idSonG = rs.getString("SONG_ID");
                String nameSong = rs.getString("NAME");
                String artistSong = rs.getString("ARTIST");
                String GenderSong = rs.getString("GENRE");
                String length = rs.getString("LENGTH");
                String filePath = rs.getString("FILE_PATH");

                addItem(new Song(idSonG, nameSong, Integer.parseInt(length), GenderSong,
                        artistSong, filePath));
            }
        } catch (Exception ignored) {

        }

    }
}
