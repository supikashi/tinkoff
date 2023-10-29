package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int cursor;

    public BackwardIterator(List<T> list) {
        this.list = list;
        this.cursor = this.list.size();
    }

    @Override
    public boolean hasNext() {
        return this.cursor != 0;
    }

    @Override
    public T next() {
        cursor--;
        return list.get(cursor);
    }
}
