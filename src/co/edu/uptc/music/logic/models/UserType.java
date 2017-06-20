package co.edu.uptc.music.logic.models;

public enum UserType {
    ADMIN("US01"), PREMIUM("US02"), ARTIST("US03"), NORMAL("US04"), GUEST("US05");

    String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static UserType getUserForString(String type) {
        switch (type.toUpperCase()) {
            case "US01":
                return ADMIN;
            case "US02":
                return PREMIUM;
            case "US03":
                return ARTIST;
            case "US04":
                return NORMAL;
            default:
                return GUEST;
        }
    }
}