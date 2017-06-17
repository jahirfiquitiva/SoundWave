package co.edu.uptc.music.logic;

public enum UserType {
    ADMIN("US01"), NORMAL("US03"), GUEST("US02");

    String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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