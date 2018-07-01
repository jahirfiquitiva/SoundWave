package co.soundwave.managers

import co.soundwave.extensions.ignore
import co.soundwave.models.Album
import co.soundwave.models.Artist
import co.soundwave.models.Song
import co.soundwave.repository.song.SongDAO

class SongsManager : BaseManager<SongDAO, Pair<Song, Pair<Album, Artist>>>() {
    
    override val dao: SongDAO = SongDAO()
    
    private val albumsManager: AlbumsManager = AlbumsManager()
    
    fun removeSong(name: String): Boolean {
        return findItem(name)?.let { removeItem(it) } ?: false
    }
    
    override fun findItem(id: Int): Pair<Song, Pair<Album, Artist>>? =
        getList().firstOrNull { it.first.id == id }
    
    override fun findItem(s: String): Pair<Song, Pair<Album, Artist>>? =
        getList().firstOrNull { it.first.name.equals(s, true) }
    
    override fun load() {
        albumsManager.load()
        dao.query()?.let {
            ignore {
                clearList()
                while (it.next()) {
                    val id = it.getInt("id_${dao.sql.tableName()}")
                    val name = it.getString("name_${dao.sql.tableName()}")
                    val track = it.getInt("track_${dao.sql.tableName()}")
                    val length = it.getInt("length_${dao.sql.tableName()}")
                    val path = it.getString("path_${dao.sql.tableName()}")
                    val albumId = it.getInt("album_id_album")
                    val album = albumsManager.getList().firstOrNull { it.first.id == albumId }
                    album ?: continue
                    addItem(Pair(Song(id, name, track, length, path), album))
                }
            }
        }
    }
    
    fun getSongsInPlaylist(playlistId: Int): ArrayList<Pair<Song, Pair<Album, Artist>>> {
        val list = ArrayList<Pair<Song, Pair<Album, Artist>>>()
        return dao.queryExecutor(
            "select * from playlist_has_song where playlist_id_playlist = '$playlistId'")?.let {
            ignore {
                list.clear()
                val songsIds = ArrayList<Int>()
                while (it.next()) {
                    songsIds.add(it.getInt("song_id_song"))
                }
                load()
                songsIds.forEach {
                    findItem(it)?.let { list.add(it) }
                }
            }
            list
        } ?: list
    }
}