package co.soundwave.managers

import co.soundwave.extensions.ignore
import co.soundwave.models.Genre
import co.soundwave.repository.genre.GenreDAO

class GenresManager : BaseManager<GenreDAO, Genre>() {
    
    override val dao: GenreDAO = GenreDAO()
    
    override fun findItem(id: Int): Genre? = getList().firstOrNull { it.id == id }
    
    override fun findItem(s: String): Genre? = getList().firstOrNull { it.name.equals(s, true) }
    
    override fun load() {
        dao.query()?.let {
            ignore {
                clearList()
                while (it.next()) {
                    val genId = it.getInt("id_${dao.sql.tableName()}")
                    val desc = it.getString("name_${dao.sql.tableName()}")
                    val imgPath = it.getString("img_path_${dao.sql.tableName()}")
                    addItem(Genre(genId, desc, imgPath))
                }
            }
        }
    }
}