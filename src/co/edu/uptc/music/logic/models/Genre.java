package co.edu.uptc.music.logic.models;

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
