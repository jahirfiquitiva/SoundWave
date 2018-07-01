package co.soundwave.managers

import co.soundwave.models.Playlist
import co.soundwave.models.User
import co.soundwave.repository.playlist.PlaylistDAO
import co.soundwave.repository.user.UserDAO

class PlaylistsManager : BaseManager<PlaylistDAO, Playlist>() {
    
    override val dao: PlaylistDAO = PlaylistDAO()
    private val userDao: UserDAO = UserDAO()
    
    override fun load() = load(-1)
    
    fun load(userId: Int) {
        val realId = getUserId(userId)
        dao.queryByUserId(realId)?.let {
            clearList()
            while (it.next()) {
                addItem(
                    Playlist(
                        it.getInt("id_${dao.sql.tableName()}"),
                        it.getString("name_${dao.sql.tableName()}")))
            }
        }
    }
    
    override fun findItem(id: Int): Playlist? = getList().firstOrNull { it.id == id }
    
    override fun findItem(s: String): Playlist? = getList().firstOrNull { it.name.equals(s, true) }
    
    fun createNewPlaylist(name: String, userId: Int): Boolean =
        dao.insert(dao.getInsertQuery(Playlist(0, name), userId))
    
    fun createFavsPlaylist(userId: Int): Boolean {
        val result = dao.insert(dao.getInsertQuery(Playlist(0, "Favorites"), userId))
        load()
        return result
    }
    
    fun addSongToPlaylist(playlistId: Int, songId: Int): Boolean {
        val result = dao.addSongToPlaylist(playlistId, songId)
        load()
        return result
    }
    
    fun addSongToFavorites(songId: Int): Boolean =
        addSongToPlaylist(getFavoritesPlaylistId(), songId)
    
    private fun getFavoritesPlaylistId(): Int {
        return dao.query(name = "Favorites")?.let {
            val favs = ArrayList<Playlist>()
            favs.clear()
            while (it.next()) {
                favs.add(
                    Playlist(
                        it.getInt("id_${dao.sql.tableName()}"),
                        it.getString("name_${dao.sql.tableName()}")))
            }
            favs.firstOrNull { it.name.equals("Favorites", true) }?.id ?: -1
        } ?: -1
    }
    
    /*
    fun addListToUser(id: String, name: String): Boolean {
        return dao.addListToUser(id, name)
    }
    */
    
    private fun getUserId(id: Int): Int {
        val userRs = userDao.query(id = id)
        return userRs?.let {
            val usersList = ArrayList<User>()
            while (it.next()) {
                usersList.add(
                    User(
                        it.getInt("id_${userDao.sql.tableName()}"),
                        it.getInt("doc_${userDao.sql.tableName()}"),
                        it.getString("name_${userDao.sql.tableName()}"),
                        it.getString("last_name_${userDao.sql.tableName()}"),
                        it.getInt("age_${userDao.sql.tableName()}"),
                        it.getString("nick_${userDao.sql.tableName()}"),
                        it.getString("email_${userDao.sql.tableName()}"),
                        it.getString("password_${userDao.sql.tableName()}")
                        ))
            }
            usersList.firstOrNull()?.id ?: -1
        } ?: -1
    }
    
}