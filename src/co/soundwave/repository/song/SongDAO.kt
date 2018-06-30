package co.soundwave.repository.song

import co.soundwave.models.Song
import co.soundwave.repository.BaseDAO

class SongDAO : BaseDAO<SongSQL, Song>() {
    override val sql: SongSQL by lazy { SongSQL() }
    fun getInsertQuery(obj: Song, genreId: Int, albumId: Int): String =
        sql.insertSong(obj.name, obj.track, obj.length, obj.path, genreId, albumId)
}