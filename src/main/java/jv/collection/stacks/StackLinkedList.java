package jv.collection.stacks;

import java.util.Iterator;

public class StackLinkedList<T> implements Stack<T> {
    private Node first;

    public void push(T item) {
        first = new Node(item, first);
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        final T item;
        final Node next;

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<T> {
        private Node first;

        private ListIterator(Node first) {
            this.first = first;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            T value = first.item;
            first = first.next;
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }
}
