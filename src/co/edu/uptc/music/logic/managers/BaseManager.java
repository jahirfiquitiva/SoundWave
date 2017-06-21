package co.edu.uptc.music.logic.managers;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public abstract class BaseManager<T> {
    private ArrayList<T> list;

    public BaseManager() {
        this.list = new ArrayList<>();
    }

    public boolean addItem(@NotNull T item) {
        if (list.contains(item)) return false;
        list.add(item);
        return true;
    }

    public abstract T findItem(@NotNull String s);

    public boolean removeItem(@NotNull T item) {
        if (list.contains(item)) {
            list.remove(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(int index) {
        return removeItem(list.get(index));
    }

    @SuppressWarnings("unchecked")
    public ArrayList<T> getList() {
        return (ArrayList<T>) list.clone();
    }

    public void clearList() {
        list.clear();
    }

    public int getListSize() {
        return list != null ? list.size() : 0;
    }

}