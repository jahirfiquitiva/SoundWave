package co.soundwave.repository.playlist

import co.soundwave.repository.BaseSQL

class PlaylistSQL : BaseSQL() {
    fun insertPlaylist(name: String, userId: Int): String =
        "insert into ${tableName()}(name_${tableName()}, user_id_user) values ('$name', '$userId');"
    
    override fun tableName(): String = "playlist"
    
    fun queryByUserId(userId: Int): String =
        "select * from ${tableName()} where user_id_user = '$userId'"
}