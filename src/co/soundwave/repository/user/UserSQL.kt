package co.soundwave.repository.user

import co.soundwave.repository.BaseSQL

class UserSQL : BaseSQL() {
    fun insertUser(
        doc: Int,
        name: String,
        last_name: String,
        age: Int,
        nick: String,
        email: String,
        password: String
                  ): String =
        "insert into ${tableName()}(doc_${tableName()}, name_${tableName()}, " +
            "last_name_${tableName()}, age_${tableName()}, nick_${tableName()}, email_${tableName()}, " +
            "password_${tableName()}) values ('$doc','$name', '$last_name', '$age'" +
            "'$nick', '$email', md5('$password'));"
    
    override fun tableName(): String = "user"
}