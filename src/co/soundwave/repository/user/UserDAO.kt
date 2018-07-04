package co.soundwave.repository.user

import co.soundwave.models.User
import co.soundwave.repository.BaseDAO

class UserDAO : BaseDAO<UserSQL, User>() {
    override val sql: UserSQL by lazy { UserSQL() }
    fun getInsertQuery(obj: User): String =
        sql.insertUser(
            obj.document, obj.name, obj.lastName, obj.age, obj.nick, obj.email, obj.password)
}