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


    public String songsByArtists() {
        /*return "SELECT SONGS.NAME,SONGS.GENRE,SONGS.ARTIST,SONGS.LENGTH FROM SONGS GROUP BY
        SONGS" +
                ".ARTIST";*/
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS.LENGTH,SONGS" +
                ".FILE_PATH,SONGS.IMG_PATH FROM SONGS ORDER BY SONGS.ARTIST";
    }


    public String songsByGenre() {
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS.LENGTH,SONGS" +
                ".FILE_PATH,SONGS.IMG_PATH FROM SONGS INNER JOIN GENRES ON SONGS.GENRE=GENRES" +
                ".GENRE_ID ORDER BY GENRE_ID";
    }


    public String userPlaylist(String userId) {
        //despues cuando ya tengamos listas mandamos el nombre de usuario
        /*return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS.LENGTH,SONGS"  +
                ".FILE_PATH,SONGS.IMG_PATH FROM USERS INNER JOIN " +
                "(PLAYLISTS_USERS INNER JOIN (PLAYLISTS INNER JOIN (SONGS_PLAYLISTS INNER JOIN " +
                "SONGS ON SONGS_PLAYLISTS.F_SONG_ID=SONGS.SONG_ID) ON PLAYLISTS" +
                ".PL_ID=SONGS_PLAYLISTS.F_PL_ID) ON PLAYLISTS_USERS.F_PL_ID=PLAYLISTS.PL_ID) ON " +
                "USERS.USER_ID=PLAYLISTS_USERS.F_USER_ID WHERE USERS.USER_ID=\'" + userId + "\'";
        */

            return "select songs.SONG_ID,songs.NAME,songs.ARTIST,songs.GENRE,songs.LENGTH,songs" +
                    ".FILE_PATH,songs.IMG_PATH FROM users inner join (playlists_users inner join " +
                    "(playlists inner join (songs_playlists inner join songs on songs_playlists" +
                    ".F_SONG_ID=songs.SONG_ID) on playlists.PL_ID=songs_playlists.F_PL_ID) on " +
                    "playlists_users.F_PL_ID=playlists.PL_ID) on users.USER_ID=playlists_users" +
                    ".F_USER_ID " +"where users.USER_ID="+userId+"and playlists.PL_ID=\"PL000\"";

    }

    public String addPlayList(String id, String name) {
        return "INSERT INTO PLAYLISTS VALUES (\'" + id + "\',\'" + name + "\')";
    }

    public String addSongsToPlaylist(String listId, String songId) {
        return "INSERT INTO SONGS_PLAYLISTS VALUES(\'" + songId + "\',\'" + listId + "\');";
    }

    public String addListToUser(String listId, String userId) {
        return "INSERT INTO PLAYLISTS_USERS VALUES(\'" + listId + "\',\'" + userId + "\');";
    }

    public String addSongstoUser(String songId, String userId) {
        return "INSERT INTO USERS_SONGS VALUES(\'" + userId + "\',\'" + songId + "\');";
    }


}