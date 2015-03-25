package jv.collection.queues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueLinkedListTest {
    private Queue<String> queue = new QueueLinkedList<>();

    @Test
    public void emptyQueueShouldBeEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void emptyQueueShouldThrowExceptionWhenDequeue() {
        queue.dequeue();
    }

    @Test
    public void queueShouldBeNonEmptyIfElementIsEnqueued() {
        queue.enqueue("1");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void queueShouldDequeueEnqueuedElement() {
        String expected = "1";
        queue.enqueue(expected);
        String actual = queue.dequeue();
        assertEquals(expected, actual);
    }

    @Test
    public void enqueueAndDequeueFewTimes() {
        String expected1 = "1";
        String expected2 = "2";
        queue.enqueue(expected1);
        queue.enqueue(expected2);

        assertEquals(expected1, queue.dequeue());
        assertEquals(expected2, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

}