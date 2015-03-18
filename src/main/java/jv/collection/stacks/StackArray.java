package jv.collection.stacks;

import java.util.Iterator;

public class StackArray<T> implements Stack<T> {
    private int n = 0;
    private final T[] data;

    @SuppressWarnings("unchecked")
    public StackArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        data[n++] = item;
    }

    @Override
    public T pop() {
        T elem = data[--n];
        data[n] = null;
        return elem;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(data, n);
    }
}
