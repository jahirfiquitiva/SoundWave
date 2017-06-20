package co.edu.uptc.music.logic.managers;

import co.edu.uptc.music.logic.models.Song;

public class PlaylistManager extends BaseManager<Song> {
    @Override
    public Song findItem(String s) {
        return null;
    }

    /*

    private SongDAO songDAO;
    private SongsManager song;

    public PlaylistManager() {
        super();
        songDAO=new SongDAO();
        song=new SongsManager();

    }

    @Override
    public Song findItem(String s) {
        return null;
    }

    public boolean addPlaylist(String name, String owner) {
        return addItem(new Playlist(name, owner));
    }

    public boolean removePlaylist(String name) {
        return removeItem(findItem(name));
    }

    public void loadPlayListFav(String idUser) {
        internalLoad(songDAO.PlayFavorites(idUser));
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
                    String length = rs.getString("LENGTH");
                    String path = rs.getString("FILE_PATH");
                    String img = rs.getString("IMG_PATH");
                    addItem(new Song(id, name, artist, GenreType.getGenreForString(genre),
                            Integer.parseInt(length), path, img));
                }
            } catch (Exception ignored) {
            }
        }
    }


    @Override
    public Playlist findItem(String s) {
        for (Playlist list : getList()) {
            if (list.getName().equalsIgnoreCase(s)) return list;
        }
        return null;
    }

*/
}