package edu.hw3.Task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> collection;
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
        if (cursor < 0) {
            throw new NoSuchElementException();
        }
        return collection.get(cursor);
    }
}
