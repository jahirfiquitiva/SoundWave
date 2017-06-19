package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.models.Genre;
import co.edu.uptc.music.persistence.GenreDAO;

public class GenreManager extends BaseManager<Genre> {

    private GenreDAO genreDAO;

    public GenreManager() {
        genreDAO = new GenreDAO();
    }

    @Override
    public Genre findItem(String s) {

        for (Genre gener : getList()) {
            if (gener.getGenreId().equalsIgnoreCase(s)) return gener;
        }
        return null;
    }

    private void internalLoad(ResultSet res) {
        if (res != null) {
            try {
                clearList();
                while (res.next()) {
                    String genId = res.getString("GENRE_ID");
                    String descri = res.getString("DESCRIPTION");
                    String imgPat = res.getString("IMG_PATH");
                    addItem(new Genre(genId, descri, imgPat));
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void loadGenres() {
        internalLoad(genreDAO.queryGenres());
    }


}
