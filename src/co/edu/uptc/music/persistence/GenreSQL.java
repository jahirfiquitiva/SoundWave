package co.edu.uptc.music.persistence;

public class GenreSQL {

    public String queryGenres() {
        return "SELECT * FROM GENRES;";
    }

    public String queryGenre(String idGen) {
        return "SELECT * FROM GENRES WHERE GENRE_ID=\'" + idGen + "\';";
    }

    public String insertGenres(String idG, String descG, String path) {
        return "INSERT INTO GENRES VALUES(\'" + idG + "\',\'" + descG + "\',\'" + ",\'" + path +
                "\')";
    }

    public String deleteGenre(String idGen) {
        return "DROP GENRES WHERE GENRE_ID='" + idGen + "';";
    }
}
