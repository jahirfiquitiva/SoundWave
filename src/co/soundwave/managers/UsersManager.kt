package co.soundwave.managers

import co.soundwave.extensions.ignore
import co.soundwave.models.User
import co.soundwave.repository.user.UserDAO

class UsersManager : BaseManager<UserDAO, User>() {
    
    override val dao: UserDAO = UserDAO()
    
    override fun load() {
        dao.query()?.let {
            ignore {
                clearList()
                while (it.next()) {
                    val id = it.getInt("id_${dao.sql.tableName()}")
                    val doc = it.getInt("doc_${dao.sql.tableName()}")
                    val name = it.getString("name_${dao.sql.tableName()}")
                    val lastName = it.getString("last_name_${dao.sql.tableName()}")
                    val age = it.getInt("age_${dao.sql.tableName()}")
                    val nick = it.getString("nick_${dao.sql.tableName()}")
                    val email = it.getString("email_${dao.sql.tableName()}")
                    val password = it.getString("password_${dao.sql.tableName()}")
                    addItem(User(id, doc, name, lastName, age, nick, email, password))
                }
            }
        }
    }
    
    override fun findItem(id: Int): User? = getList().firstOrNull { it.id == id }
    
    override fun findItem(s: String): User? = getList().firstOrNull { it.nick.equals(s, true) }
    
    fun addNewUser(
        doc: Int,
        name: String,
        lastName: String,
        age: Int,
        nick: String,
        email: String,
        password: String
                  ): Boolean {
        return dao.insert(
            dao.getInsertQuery(User(0, doc, name, lastName, age, nick, email, password)))
    }
}