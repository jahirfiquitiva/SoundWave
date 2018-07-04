package co.soundwave.repository.playlist

import co.soundwave.models.Playlist
import co.soundwave.repository.BaseDAO
import java.sql.ResultSet

class PlaylistDAO : BaseDAO<PlaylistSQL, Playlist>() {
    override val sql: PlaylistSQL by lazy { PlaylistSQL() }
    
    fun getInsertQuery(obj: Playlist, userId: Int): String =
        sql.insertPlaylist(obj.name, userId)
    
    fun queryByUserId(userId: Int): ResultSet? =
        queryExecutor(sql.queryByUserId(userId))
    
    fun addSongToPlaylist(playlistId: Int, songId: Int): Boolean =
        insert("insert into playlist_has_song values ('$playlistId', '$songId')")
}