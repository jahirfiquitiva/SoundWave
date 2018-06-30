package co.soundwave.repository.song

import co.soundwave.repository.BaseSQL

class SongSQL : BaseSQL() {
    fun insertSong(
        name: String,
        track: Int,
        length: Int,
        path: String,
        genreId: Int,
        albumId: Int
                  ): String =
        "insert into ${tableName()}(name_${tableName()}, track_${tableName()}, length_${tableName()}, " +
            "path_${tableName()}, genre_id_genre, album_id_album) values " +
            "('$name', '$track', '$length', '$path', '$genreId', '$albumId');"
    
    override fun tableName(): String = "song"
}