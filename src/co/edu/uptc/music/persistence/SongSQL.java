package co.edu.uptc.music.persistence;

public class SongSQL {

    public String querySongs() {
        return "SELECT * FROM SONGS;";
    }

    public String querySong(String idSong) {
        return "SELECT * FROM SONGS WHERE USER_ID=\'" + idSong + "\';";
    }

    public String insertSong(String idSong, String nameSong, String artistSong, String gender,
                             String lenght,
                             String file_Path) {

        return "insert into songs values ('" + idSong + "','" + nameSong + "','" + artistSong +
                "','" + gender
                + "','" + lenght + "','" + file_Path + "')";
    }

    public String deleteSong(String idSong) {
        return "DROP songs WHERE USER_ID='" + idSong + "';";
    }

}
