package co.edu.uptc.music.logic;

public enum UserType {
    ADMIN, NORMAL, GUEST;

    public static UserType getUserForString(String type) {
        switch (type) {
            case "US01":
                return ADMIN;
            case "US03":
                return NORMAL;
            default:
                return GUEST;
        }
    }
}