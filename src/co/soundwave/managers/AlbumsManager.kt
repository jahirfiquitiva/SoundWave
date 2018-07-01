package co.soundwave.managers

import co.soundwave.models.Album
import co.soundwave.repository.album.AlbumDAO

class AlbumsManager : BaseManager<AlbumDAO, Album>() {
    override val dao: AlbumDAO = AlbumDAO()

    override fun findItem(id: Int): Album? = getList().firstOrNull { it.id == id }

    override fun findItem(s: String): Album? = getList().firstOrNull { it.name.equals(s, true) }

    override fun load() {
        dao.queryExecutor(dao.sql.query())?.let {
            clearList()
            while (it.next()) {
                val id = it.getInt("id_${dao.sql.tableName()}")
                val name = it.getString("name_${dao.sql.tableName()}")
                val imgPath = it.getString("img_path_${dao.sql.tableName()}")
                val releaseYear = it.getInt("release_year_${dao.sql.tableName()}")
                addItem(Album(id, name, imgPath, releaseYear))
            }
        }
    }

}