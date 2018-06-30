package co.soundwave.repository.genre

import co.soundwave.repository.BaseSQL

class GenreSQL : BaseSQL() {
    fun insertGenres(name: String, path: String): String =
        "insert into ${tableName()}(name_${tableName()}, img_path_${tableName()}) values ('$name', '$path');"
    
    override fun tableName(): String = "genre"
}