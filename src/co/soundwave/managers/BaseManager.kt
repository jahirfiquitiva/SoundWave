package co.soundwave.managers

import co.soundwave.repository.BaseDAO
import java.util.ArrayList

abstract class BaseManager<DAO : BaseDAO<*, *>, T> {
    private val list: ArrayList<T> = ArrayList()
    internal abstract val dao: DAO
    
    fun addItem(item: T): Boolean {
        if (list.contains(item)) return false
        list.add(item)
        return true
    }
    
    fun removeItem(item: T): Boolean {
        if (list.contains(item)) {
            list.remove(item)
            return true
        }
        return false
    }
    
    fun removeItem(index: Int): Boolean {
        return removeItem(list[index])
    }
    
    fun getList(): ArrayList<T> {
        return ArrayList(list)
    }
    
    fun clearList() {
        list.clear()
    }
    
    abstract fun findItem(id: Int): T?
    
    abstract fun findItem(s: String): T?
    
    abstract fun load()
}