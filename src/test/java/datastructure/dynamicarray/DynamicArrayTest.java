package datastructure.dynamicarray;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;


public class DynamicArrayTest {
    private DynamicArray<Integer> dynamicArray;

    @BeforeEach
    public void setUp() {
        dynamicArray = new DynamicArray<>();
    }

    @Test
    public void testEmptyList() {
        assertTrue(dynamicArray.isEmpty());
        assertEquals(0, dynamicArray.size());
    }

    @Test
    public void testListSize() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(3, dynamicArray.size());
    }

    @Test
    public void testGet() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        assertEquals(1, dynamicArray.get(0));
        assertEquals(3, dynamicArray.get(2));
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    dynamicArray.get(5);
                });

        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    dynamicArray.get(-1);
                });
        assertEquals("Provide Index within Range", exception.getMessage());
    }

    @Test
    public void testSet() {
        dynamicArray.add(1);
        dynamicArray.set(0, 2);
        assertEquals(2, dynamicArray.get(0));
        dynamicArray.set(0, 3);
        assertEquals(3, dynamicArray.get(0));
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    dynamicArray.set(5, 2);
                });
        assertEquals("Provide Index within Range", exception.getMessage());
    }

    @Test
    public void testClear() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertEquals(5, dynamicArray.size());
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.clear();
        assertEquals(0, dynamicArray.size());
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add(6);
        dynamicArray.add(7);
        dynamicArray.add(8);
        assertEquals(3, dynamicArray.size());
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.clear();
        assertEquals(0, dynamicArray.size());
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void testRemoveAt() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertEquals(2, (int) dynamicArray.removeAt(1));
        assertEquals(4, dynamicArray.size());
        assertEquals(3, (int) dynamicArray.removeAt(1));
        assertEquals(3, dynamicArray.size());
        assertEquals(1, (int) dynamicArray.removeAt(0));
        assertEquals(2, dynamicArray.size());
    }

    @Test
    public void testAdd() {
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add(0);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(1, dynamicArray.size());
        dynamicArray.add(1);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(2, dynamicArray.size());
        dynamicArray.add(2);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(3, dynamicArray.size());
        for (int i = 4; i < 16; i++) {
            dynamicArray.add(i);
        }
        dynamicArray.add(16);
        assertFalse(dynamicArray.isEmpty());
        assertEquals(16, dynamicArray.size());
    }

    @Test
    public void testRemoveAtOnEmptyList() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    dynamicArray.removeAt(0);
                });
    }

    @Test
    public void testRemoveOnEmptyList() {
        assertFalse(dynamicArray.remove(0));
    }

    @Test
    public void testRemove() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        dynamicArray.remove(1);
        dynamicArray.remove(5);
        dynamicArray.remove(2);
        dynamicArray.remove(3);
        dynamicArray.remove(4);
        assertEquals(0, dynamicArray.size());
        assertTrue(dynamicArray.isEmpty());
    }

    @Test
    public void testIndexOf() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertEquals(0, dynamicArray.indexOf(1));
        assertEquals(1, dynamicArray.indexOf(2));
        dynamicArray.removeAt(0);
        assertEquals(0, dynamicArray.indexOf(2));
    }

    @Test
    public void testContains() {
        dynamicArray.add(1);
        assertTrue(dynamicArray.contains(1));
        dynamicArray.remove(1);
        assertFalse(dynamicArray.contains(1));
    }

    @Test
    public void testIteratorOneElementInQueue() {
        dynamicArray.add(1);
        Iterator iterator = dynamicArray.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorMultipleElementInQueue() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        Iterator iterator = dynamicArray.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @AfterEach
    public void tearDown() {
        dynamicArray = null;
    }
}