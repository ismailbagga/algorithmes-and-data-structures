package com.ismail.coder.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    DynamicArray<Integer> emptyArray;
    DynamicArray<Integer> oneItemArray;
    DynamicArray<Integer> manyItemArray;

    @BeforeEach
    void setUp() {
        emptyArray = new DynamicArray<>();
        oneItemArray = new DynamicArray<>();
        oneItemArray.add(10);
        manyItemArray = new DynamicArray<>();
        manyItemArray.add(7);
        manyItemArray.add(8);
        manyItemArray.add(-3);
        manyItemArray.add(50);
        manyItemArray.add(66);
        manyItemArray.add(9);
    }


    @Test
    void add() {
        var array = new DynamicArray<Integer>();
        assertEquals(0, array.size());
        array.add(-1);
        assertEquals(1, array.size());
        array.add(10);
        array.add(20);
        assertEquals(3, array.size());
        assertEquals("[-1,10,20]", array.display());
    }

    @Test
    void get() {
        assertThrows(IndexOutOfBoundsException.class, () -> emptyArray.get(1));
        assertEquals(10, oneItemArray.get(0));
        assertEquals(50, manyItemArray.get(3));
        assertEquals(9, manyItemArray.get(manyItemArray.size() - 1));
    }

    @Test
    void set() {

        manyItemArray.set(2, 99);
        assertEquals(99, manyItemArray.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyArray.set(0, 50));

    }

    @Test
    void max_and_max() {
        assertNull(emptyArray.max());
        assertNull(emptyArray.min());
        assertNull(emptyArray.min());


        assertEquals(10, oneItemArray.max());
        assertEquals(10, oneItemArray.min());

        assertEquals(-3, manyItemArray.min());
        assertEquals(66, manyItemArray.max());


    }
}