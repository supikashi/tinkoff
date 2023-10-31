package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {
    private final ArrayList<T> collection;
    private int cursor;

    public BackwardIterator(Collection<T> collection) {
        this.collection = new ArrayList<>(collection.stream().toList());
        this.cursor = this.collection.size();
    }

    @Override
    public boolean hasNext() {
        return this.cursor != 0;
    }

    @Override
    public T next() {
        cursor--;
        return collection.get(cursor);
    }
}
