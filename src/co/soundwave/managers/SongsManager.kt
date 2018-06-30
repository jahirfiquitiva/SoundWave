package co.soundwave.managers

import co.soundwave.extensions.ignore
import co.soundwave.models.Song
import co.soundwave.repository.song.SongDAO

class SongsManager : BaseManager<SongDAO, Song>() {
    override val dao: SongDAO = SongDAO()
    
    fun removeSong(name: String): Boolean {
        return findItem(name)?.let { removeItem(it) } ?: false
    }
    
    override fun findItem(id: Int): Song? = getList().firstOrNull { it.id == id }
    
    override fun findItem(s: String): Song? = getList().firstOrNull { it.name.equals(s, true) }
    
    override fun load() {
        dao.query()?.let {
            ignore {
                clearList()
                while (it.next()) {
                    val id = it.getInt("id_${dao.sql.tableName()}")
                    val name = it.getString("name_${dao.sql.tableName()}")
                    val track = it.getInt("track_${dao.sql.tableName()}")
                    val length = it.getInt("length_${dao.sql.tableName()}")
                    val path = it.getString("path_${dao.sql.tableName()}")
                    addItem(Song(id, name, track, length, path))
                }
            }
        }
    }
    
    fun getSongsInPlaylist(playlistId: Int): ArrayList<Song> {
        val list = ArrayList<Song>()
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