package co.soundwave.repository

import co.soundwave.extensions.ignore
import java.sql.Connection
import java.sql.DriverManager

class DatabaseConnection {
    
    var connection: Connection? = null
        private set
    
    fun connectToDB(): Boolean {
        var connected = false
        ignore {
            Class.forName(DRIVER).newInstance()
            connection = DriverManager.getConnection(URL, USER, PASSWORD)
            connected = true
        }
        return connected
    }
    
    fun close() {
        ignore { connection?.close() }
    }
    
    companion object {
        private const val DRIVER = "com.mysql.cj.jdbc.Driver"
        private const val URL = "jdbc:mysql://localhost:3306/soundwave"
        private const val USER = "rick"
        private const val PASSWORD = "rick"
    }
}