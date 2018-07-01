package co.soundwave.models

data class Artist(
    val id: Int,
    val name: String,
    val nick: String,
    val email: String,
    val password: String
                 ) {
    
    fun validate(otherPassword: String): Boolean =
        password.equals(otherPassword, true)
}