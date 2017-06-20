package co.edu.uptc.music.logic.models;

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