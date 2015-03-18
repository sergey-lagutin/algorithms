package jv.collection.stacks;

import java.util.Iterator;

class ArrayIterator<T> implements Iterator<T> {
    private final T[] data;
    private int i;

    public ArrayIterator(T[] data, int n) {
        this.data = data;
        i = n;
    }

    @Override
    public boolean hasNext() {
        return i > 0;
    }

    @Override
    public T next() {
        return data[--i];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
