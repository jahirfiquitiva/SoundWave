package co.soundwave.repository.album

import co.soundwave.models.Album
import co.soundwave.repository.BaseDAO

class AlbumDAO : BaseDAO<AlbumSQL, Album>() {
    override val sql: AlbumSQL by lazy { AlbumSQL() }
    fun getInsertQuery(obj: Album, artistId: Int): String =
        sql.insertAlbum(obj.name, obj.imgPath, obj.releaseYear, artistId)
}