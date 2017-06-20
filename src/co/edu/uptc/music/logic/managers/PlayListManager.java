package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.models.Playlist;
import co.edu.uptc.music.persistence.SongDAO;

public class PlayListManager extends BaseManager<Playlist> {

    private SongDAO dao;

    public PlayListManager() {
        dao = new SongDAO();
    }

    public void load(String user) {
        ResultSet rs = dao.queryPlaylists(user);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String userId = rs.getString("PL_ID");
                    String name = rs.getString("NAME");
                    addItem(new Playlist(userId, name));
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

}