package co.soundwave.repository.genre

import co.soundwave.models.Genre
import co.soundwave.repository.BaseDAO

class GenreDAO : BaseDAO<GenreSQL, Genre>() {
    override val sql: GenreSQL by lazy { GenreSQL() }
    fun getInsertQuery(obj: Genre): String =
        sql.insertGenres(obj.name, obj.imgPath)
}