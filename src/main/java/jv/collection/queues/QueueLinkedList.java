package jv.collection.queues;

public class QueueLinkedList<T> implements Queue<T> {
    private Node first = null;
    private Node last = null;

    @Override
    public void enqueue(T item) {
        Node node = new Node(item, null);
        if (isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }

        T value = first.value;
        first = first.next;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private class Node {
        private final T value;
        private Node next;

        private Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
