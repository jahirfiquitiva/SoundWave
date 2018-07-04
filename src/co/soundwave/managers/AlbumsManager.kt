package co.soundwave.managers

import co.soundwave.models.Album
import co.soundwave.models.Artist
import co.soundwave.repository.album.AlbumDAO

class AlbumsManager : BaseManager<AlbumDAO, Pair<Album, Artist>>() {
    
    override val dao: AlbumDAO = AlbumDAO()
    
    private val artistsManager: ArtistsManager = ArtistsManager()
    
    override fun findItem(id: Int): Pair<Album, Artist>? =
        getList().firstOrNull { it.first.id == id }
    
    override fun findItem(s: String): Pair<Album, Artist>? =
        getList().firstOrNull { it.first.name.equals(s, true) }
    
    override fun load() {
        artistsManager.load()
        dao.queryExecutor(dao.sql.query())?.let {
            clearList()
            while (it.next()) {
                val id = it.getInt("id_${dao.sql.tableName()}")
                val name = it.getString("name_${dao.sql.tableName()}")
                val imgPath = it.getString("img_path_${dao.sql.tableName()}")
                val releaseYear = it.getInt("release_year_${dao.sql.tableName()}")
                val artistId = it.getInt("artist_id_artist")
                val artist = artistsManager.findItem(artistId)
                artist ?: continue
                addItem(Pair(Album(id, name, imgPath, releaseYear), artist))
            }
        }
    }
}