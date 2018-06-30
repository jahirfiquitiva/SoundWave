package co.soundwave.repository.artist

import co.soundwave.repository.BaseSQL

class ArtistSQL : BaseSQL() {
    fun insertArtist(name: String, nick: String, email: String, password: String): String =
        "insert into ${tableName()}(name_${tableName()}, nick_${tableName()}, email_${tableName()}, " +
            "password_${tableName()}) values ('$name', '$nick', '$email', md5('$password'));"
    
    override fun tableName(): String = "artist"
}