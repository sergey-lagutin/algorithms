package jv.collection.stacks;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class StackArrayResizing<T> implements Stack<T> {
    private int n = 0;
    private T[] data = (T[]) new Object[1];

    @Override
    public void push(T item) {
        if (n == data.length) {
            resize(2 * data.length);
        }
        data[n++] = item;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(data, 0, copy, 0, n);
        data = copy;
    }

    @Override
    public T pop() {
        T item = data[--n];
        data[n] = null; // remove unused reference from array
        if (n > 0 && n == data.length / 4) {
            resize(data.length / 2);
        }
        return item;
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
