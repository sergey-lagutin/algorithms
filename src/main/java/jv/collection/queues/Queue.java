package jv.collection.queues;

public interface Queue<T> {
    void enqueue(T item);

    T dequeue();

    boolean isEmpty();
}
