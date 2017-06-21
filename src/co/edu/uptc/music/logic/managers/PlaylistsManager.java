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
                    if (!(listId.equalsIgnoreCase("favs"))) addList(listId, name);
                }
                System.out.println("Añadidas " + getList().size() + " listas de reproduccion");
            } catch (Exception ignored) {
            }
        }
    }

    private void addList(String nId, String nName) {
        if (findItem(nId) == null) {
            Playlist list = new Playlist(nId, nName);
            // TODO: Hacer funcionar -- Sin cargar canciones, funciona bien;
            list.loadSongs();
            addItem(list);
        }
    }

    @Override
    public Playlist findItem(String s) {
        for (Playlist p : getList()) {
            if (p.getId().equalsIgnoreCase(s)) return p;
        }
        return null;
    }

    public void addListToUser(String id, String name) {
        dao.addListToUser(id, name);
    }

    public void addSongsToPlaylist(String id, String songId) {
        dao.addSongsToPlaylist(id, songId);
    }

    public void createNewPlaylist(String name, String user) {
        DecimalFormat formatter = new DecimalFormat("000");
        String num = formatter.format(getListSize() + 1);
        String plId = "PL" + String.valueOf(num);
        dao.createNewPlaylist(plId, name);
        dao.addListToUser(plId, user);
    }

}