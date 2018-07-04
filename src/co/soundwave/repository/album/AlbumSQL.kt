package co.soundwave.repository.album

import co.soundwave.repository.BaseSQL

class AlbumSQL : BaseSQL() {
    fun insertAlbum(name: String, path: String, year: Int, artistId: Int): String =
        "insert into ${tableName()}(name_${tableName()}, img_path_${tableName()}," +
            " release_year_${tableName()}, artist_id_artist) values ('$name', '$path', '$year','$artistId');"
    
    override fun tableName(): String = "album"
}