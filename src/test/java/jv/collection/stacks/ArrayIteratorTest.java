package jv.collection.stacks;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayIteratorTest {
    @Test
    public void emptyArrayHasNoNextElement() {
        Iterator<String> it = new ArrayIterator<>(new String[]{}, 0);
        assertFalse(it.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeShouldThrowException() {
        Iterator<String> it = new ArrayIterator<>(new String[]{"1"}, 1);
        it.remove();
    }

    @Test
    public void nextShouldReturnArrayData() {
        String expected = "1";
        Iterator<String> it = new ArrayIterator<>(new String[]{expected}, 1);
        assertTrue(it.hasNext());
        String actual = it.next();
        assertEquals(expected, actual);
        assertFalse(it.hasNext());
    }
}