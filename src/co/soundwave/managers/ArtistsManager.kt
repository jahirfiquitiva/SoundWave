package co.soundwave.managers

import co.soundwave.extensions.ignore
import co.soundwave.models.Artist
import co.soundwave.repository.artist.ArtistDAO

class ArtistsManager : BaseManager<ArtistDAO, Artist>() {
    
    override val dao: ArtistDAO = ArtistDAO()
    
    override fun findItem(id: Int): Artist? = getList().firstOrNull { it.id == id }
    
    override fun findItem(s: String): Artist? = getList().firstOrNull { it.nick.equals(s, true) }
    
    override fun load() {
        dao.query()?.let {
            ignore {
                clearList()
                while (it.next()) {
                    val id = it.getInt("id_${dao.sql.tableName()}")
                    val name = it.getString("name_${dao.sql.tableName()}")
                    val nick = it.getString("nick_${dao.sql.tableName()}")
                    val email = it.getString("email_${dao.sql.tableName()}")
                    val password = it.getString("password_${dao.sql.tableName()}")
                    addItem(Artist(id, name, nick, email, password))
                }
            }
        }
    }
}