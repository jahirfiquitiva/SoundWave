package co.soundwave.repository.artist

import co.soundwave.models.Artist
import co.soundwave.repository.BaseDAO

class ArtistDAO : BaseDAO<ArtistSQL, Artist>() {
    override val sql: ArtistSQL by lazy { ArtistSQL() }
    fun getInsertQuery(obj: Artist): String =
        sql.insertArtist(obj.name, obj.nick, obj.email, obj.password)
}