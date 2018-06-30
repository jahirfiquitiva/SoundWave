package co.soundwave.repository

abstract class BaseSQL() {
    abstract fun tableName(): String
    
    fun query(): String = "select * from ${tableName()};"
    
    fun queryById(id: Int): String =
        "select * from ${tableName()} where id_${tableName()} = '$id';"
    
    fun queryByName(name: String): String =
        "select * from ${tableName()} where name_${tableName()} = '$name';"
    
    fun deleteWithId(id: Int): String = "delete from ${tableName()} where id_${tableName()} ='$id';"
    
    fun deleteWithName(name: String): String =
        "delete from ${tableName()} where name_${tableName()} ='$name';"
}