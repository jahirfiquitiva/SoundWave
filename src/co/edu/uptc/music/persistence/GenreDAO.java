package co.edu.uptc.music.persistence;

import java.sql.ResultSet;
import java.sql.Statement;

import co.edu.uptc.music.logic.models.Genre;

public class GenreDAO {

    private DatabaseConnection connection;
    private GenreSQL genreSQL;

    public GenreDAO() {
        this.connection = new DatabaseConnection();
        this.genreSQL = new GenreSQL();
    }


    public ResultSet queryGenres() {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                return statement.executeQuery(genreSQL.queryGenres());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void insertSong(Genre genre) throws Exception {
        if (connection.connectToDB()) {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate(genreSQL.insertGenres(genre.getGenreId(), genre.getDescription(), genre.getImgPath()));

        }
    }
    public boolean deleteGeners(String idGenre) {
        if (connection.connectToDB()) {
            try {
                Statement statement = connection.getConnection().createStatement();
                statement.executeQuery(genreSQL.deleteGenre(idGenre));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

}