package co.edu.uptc.music.persistence;

public class SongSQL {

    public String querySongs() {
        return "SELECT * FROM SONGS;";
    }

    public String querySong(String idSong) {
        return "SELECT * FROM SONGS WHERE SONG_ID=\'" + idSong + "\';";
    }

    public String insertSong(String id, String name, String artist, String genre, String length,
                             String path) {
        return "INSERT INTO SONGS VALUES(\'" + id + "\',\'" + name + "\',\'" + artist +
                "\',\'" + genre + "\'," + length + ",\'" + path + "\')";
    }

    public String deleteSong(String idSong) {
        return "DROP SONGS WHERE SONG_ID='" + idSong + "';";
    }


    public String songsArstis() {

        return "select songs.NAME,songs.GENRE,songs.ARTIST,songs.LENGTH from songs group by songs" +
                ".ARTIST ";

    }


    public String songsGender() {

        return "    select songs.NAME,songs.GENRE,songs.ARTIST,songs.LENGTH from songs inner join" +
                " genres on songs.GENRE=genres.GENRE_ID order by GENRE_ID ";

    }

}