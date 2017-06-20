package co.edu.uptc.music.logic.models;

<<<<<<< HEAD
public class Genre {
    private String genreId;
    private String description;
    private String imgPath;

    public Genre(String genreId, String description, String imgPath) {
        this.genreId = genreId;
        this.description = description;
        this.imgPath = imgPath;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId='" + genreId + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
=======
public enum Genre {
    UNKNOWN("G000"), ELECTROHOUSE("G001"), DUBSTEP("G002"), ELECTRODANCE("G003");

    String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Genre getGenreForString(String type) {
        switch (type) {
            case "G001":
                return ELECTROHOUSE;
            case "G002":
                return DUBSTEP;
            case "G003":
                return ELECTRODANCE;
            default:
                return UNKNOWN;
        }
    }
}
>>>>>>> a7b31bc9981a7721da69c894d8e0c5689351d9cf
