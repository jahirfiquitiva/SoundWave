package co.edu.uptc.music.persistence;

public class SongSQL {

    public String querySongs() {
        return "SELECT * FROM SONGS;";
    }

    public String querySong(String idSong) {
        return "SELECT * FROM SONGS WHERE SONG_ID=\'" + idSong + "\';";
    }

    public String insertSong(String id, String name, String artist, String genre, String path) {
        return "INSERT INTO SONGS VALUES(\'" + id + "\',\'" + name + "\',\'" + artist +
                "\',\'" + genre + ",\'" + path + "\')";
    }

    public String deleteSong(String idSong) {
        return "DROP SONGS WHERE SONG_ID='" + idSong + "';";
    }


    public String songsByArtists() {
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS" +
                ".FILE_PATH,SONGS.IMG_PATH FROM SONGS ORDER BY SONGS.ARTIST";
    }

    public String songsByGenre() {
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS" +
                ".FILE_PATH,SONGS.IMG_PATH FROM SONGS INNER JOIN GENRES ON SONGS.GENRE=GENRES" +
                ".GENRE_ID ORDER BY GENRE_ID";
    }

    public String queryFavorites(String userId) {
        String favsId = "F" + userId.substring(1);
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS.FILE_PATH,SONGS" +
                ".IMG_PATH FROM USERS INNER JOIN (PLAYLISTS_USERS INNER JOIN (PLAYLISTS INNER " +
                "JOIN (SONGS_PLAYLISTS INNER JOIN SONGS ON SONGS_PLAYLISTS.F_SONG_ID=SONGS" +
                ".SONG_ID) ON PLAYLISTS.PL_ID=SONGS_PLAYLISTS.F_PL_ID) ON " +
                "PLAYLISTS_USERS.F_PL_ID=PLAYLISTS.PL_ID) ON USERS.USER_ID=PLAYLISTS_USERS" +
                ".F_USER_ID WHERE PLAYLISTS.PL_ID=\'" + favsId + "\' AND USERS.USER_ID=\'" +
                userId + "\' ORDER BY SONGS.SONG_ID;";
    }

    public String queryPlaylists(String userId) {
        return "SELECT PLAYLISTS.PL_ID, PLAYLISTS.NAME FROM USERS INNER JOIN(PLAYLISTS_USERS  " +
                "INNER JOIN PLAYLISTS ON PLAYLISTS_USERS.F_PL_ID=PLAYLISTS.PL_ID)" +
                "ON USERS.USER_ID=PLAYLISTS_USERS.F_USER_ID WHERE USERS.USER_ID=\'" + userId +
                "\'ORDER BY PLAYLISTS.NAME;";
    }

    public String addNewPlaylist(String id, String name) {
        return "INSERT INTO PLAYLISTS VALUES (\'" + id + "\',\'" + name + "\')";
    }

    public String addSongsToPlaylist(String listId, String songId) {
        return "INSERT INTO SONGS_PLAYLISTS VALUES(\'" + songId + "\',\'" + listId + "\');";
    }

    public String addListToUser(String listId, String userId) {
        return "INSERT INTO PLAYLISTS_USERS VALUES(\'" + listId + "\',\'" + userId + "\');";
    }

    public String querySongsFromPlaylist(String userId, String listId) {
        return "SELECT SONGS.SONG_ID,SONGS.NAME,SONGS.ARTIST,SONGS.GENRE,SONGS" +
                ".FILE_PATH,SONGS.IMG_PATH FROM USERS INNER JOIN (PLAYLISTS_USERS INNER JOIN " +
                "(PLAYLISTS INNER JOIN (SONGS_PLAYLISTS INNER JOIN SONGS ON SONGS_PLAYLISTS" +
                ".F_SONG_ID=SONGS.SONG_ID) ON PLAYLISTS.PL_ID=SONGS_PLAYLISTS.F_PL_ID) ON " +
                "PLAYLISTS_USERS.F_PL_ID=PLAYLISTS.PL_ID) ON USERS.USER_ID=PLAYLISTS_USERS" +
                ".F_USER_ID " + "WHERE USERS.USER_ID=\'" + userId + "\' AND PLAYLISTS" +
                ".PL_ID=\'" + listId + "\'";
    }
}
