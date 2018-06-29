package co.edu.uptc.music.logic.models;

public enum UserType {
    ADMIN("US01"), ARTIST("US02"), NORMAL("US03"), GUEST("US04");

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
                return ARTIST;
            case "US03":
                return NORMAL;
            default:
                return GUEST;
        }
    }
}