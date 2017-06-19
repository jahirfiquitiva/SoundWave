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

        return "select songs.NAME,songs.GENRE,songs.ARTIST,songs.LENGTH from songs inner join " +
                "genres on songs.GENRE=genres.GENRE_ID order by GENRE_ID";


    }


    public String Playlist(String iduser) {
        //despues cuando ya tengamos listas mandamos el nombre de usuario


        return "select songs.NAME,songs.GENRE,songs.ARTIST,songs.LENGTH from users inner join " +
                "(playlists_users inner join (playlists inner join (songs_playlists inner join " +
                "songs on songs_playlists.F_SONG_ID=songs.SONG_ID) on playlists" +
                ".PL_ID=songs_playlists.F_PL_ID) on playlists_users.F_PL_ID=playlists.PL_ID) on " +
                "users.USER_ID=playlists_users.F_USER_ID where users.USER_ID='iduser'";

    }

    public String addPlayList(String id, String name) {

        return "INSERT INTO playlists VALUES ('id','name')";


    }

    public String addSongsToplayList(String idlist, String idsong) {

        return "INSERT INTO songs_playlists VALUES('idSong','idlist');";


    }

    public String addListToUser(String idlist, String idsong) {

        return "INSERT INTO playlists_users VALUES('idlist','idsong');";


    }

    public String addSongstoUser(String idsong, String user) {


        return "INSERT INTO users_songs VALUES('iduser','idsong');";

    }


}