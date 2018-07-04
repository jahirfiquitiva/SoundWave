package co.soundwave.models

data class User(
    val id: Int,
    val document: Int,
    val name: String,
    val lastName: String,
    val age: Int,
    val nick: String,
    val email: String,
    val password: String
               ) {
    
    fun validate(otherPassword: String): Boolean = password.equals(otherPassword, true)
}