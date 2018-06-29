package co.edu.uptc.music.logic.managers;

import java.sql.ResultSet;

import co.edu.uptc.music.logic.models.Genre;
import co.edu.uptc.music.persistence.GenreDAO;

public class GenresManager extends BaseManager<Genre> {

    private GenreDAO genreDAO;

    public GenresManager() {
        genreDAO = new GenreDAO();
    }

    @Override
    public Genre findItem(String s) {
        for (Genre genre : getList()) {
            if (genre.getDescription().equalsIgnoreCase(s)) return genre;
        }
        return null;
    }

    private void internalLoad(ResultSet res) {
        if (res != null) {
            try {
                clearList();
                while (res.next()) {
                    String genId = res.getString("GENRE_ID");
                    String desc = res.getString("DESCRIPTION");
                    String imgPath = res.getString("IMG_PATH");
                    addItem(new Genre(genId, desc, imgPath));
                }
            } catch (Exception ignored) {
            }
        }
    }

    public void loadGenres() {
        internalLoad(genreDAO.queryGenres());
    }

}