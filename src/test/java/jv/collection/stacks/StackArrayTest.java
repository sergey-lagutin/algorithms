package jv.collection.stacks;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackArrayTest {

    private Stack<String> stack = new StackArray<>(10);

    @Test
    public void stackWithoutElementsShouldBeEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void stackWithElementShouldBeNonEmpty() {
        stack.push("1");
        assertFalse(stack.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void popFromEmptyStackShouldThrowRuntimeException() {
        stack.pop();
    }

    @Test
    public void popShouldReturnPushedElement() {
        String expected = "1";
        stack.push(expected);
        String actual = stack.pop();
        assertEquals(expected, actual);
    }

    @Test
    public void emptyStackShouldReturnEmptyIterator() {
        Iterator<String> it = stack.iterator();
        assertFalse(it.hasNext());
    }
}