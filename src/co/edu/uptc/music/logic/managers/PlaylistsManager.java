package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;
import java.text.DecimalFormat;

import co.edu.uptc.music.logic.models.Playlist;
import co.edu.uptc.music.persistence.SongDAO;

public class PlaylistsManager extends BaseManager<Playlist> {

    private SongDAO dao;

    public PlaylistsManager() {
        super();
        dao = new SongDAO();
    }

    public void load(String user) {
        ResultSet rs = dao.queryPlaylists(user);
        if (rs != null) {
            try {
                clearList();
                while (rs.next()) {
                    String listId = rs.getString("PL_ID");
                    String name = rs.getString("NAME");
                    if (!(listId.equalsIgnoreCase("favs"))) addItem(new Playlist(listId, name));
                }
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public Playlist findItem(String s) {
        for (Playlist p : getList()) {
            if (p.getId().equalsIgnoreCase(s)) return p;
        }
        return null;
    }

    public boolean addListToUser(String id, String name) {
        return dao.addListToUser(id, name);
    }

    public boolean addSongsToPlaylist(String id, String songId) {
        return dao.addSongsToPlaylist(id, songId);
    }

    public boolean createNewPlaylist(String name, String user) {
        DecimalFormat formatter = new DecimalFormat("000");
        String num = formatter.format(getListSize() + 1);
        String plId = "PL" + String.valueOf(num);
        boolean success = dao.createNewPlaylist(plId, name);
        if (success) dao.addListToUser(plId, user);
        return success;
    }

    public boolean createFavsPlaylist(String user) {
        String favsId = "F" + user.substring(1);
        boolean success = dao.createNewPlaylist(favsId, "Favorites");
        if (success) dao.addListToUser(favsId, user);
        return success;
    }

}