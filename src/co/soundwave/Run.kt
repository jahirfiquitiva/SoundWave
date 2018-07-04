package co.soundwave

import co.soundwave.extensions.ignore
import co.soundwave.repository.user.UserDAO

class Run {
    private val dao: UserDAO = UserDAO()
    
    fun execute() {
        val rs = dao.query(0, "") ?: return
        ignore {
            while (rs.next()) {
                val userId = rs.getString("USER_ID")
                val typeRef = rs.getString("TYPE_REF")
                val username = rs.getString("USERNAME")
                val password = rs.getString("PASSWORD")
                println(userId + "\t" + typeRef + "\t" + username + "\t" + password)
            }
        }
    }
}

fun main(args: Array<String>) {
    Run().execute()
}