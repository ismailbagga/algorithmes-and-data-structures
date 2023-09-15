package com.ismail.coder.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<Integer> list;
    LinkedList<Integer> list_1;
    LinkedList<Integer> list_2;
    LinkedList<Integer> list_3;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        Integer[] array_1 = { 1, 2, 3, 4, 10 };
        Integer[] array_2 = { 1 };
        Integer[] array_3 = {};

        list_1 = new LinkedList<Integer>(array_1);
        list_2 = new LinkedList<Integer>(array_2);
        list_3 = new LinkedList<Integer>(array_3);

    }

    @Test
    void construct_from_array() {

        assertEquals(5, list_1.size());
        assertEquals(1, list_2.size());
        assertEquals(0, list_3.size());

        assertEquals("[1,2,3,4,10]", list_1.toString());
        assertEquals("[1]", list_2.toString());
        assertEquals("[]", list_3.toString());
    }

    @Test
    void insertToAnOrderList() {
        list_1.insertToAnOrderList(0);
        assertEquals(0, list_1.indexOf(0));
        list_1.insertToAnOrderList(5);
        assertEquals(5, list_1.indexOf(5));
        list_1.insertToAnOrderList(100);
        assertEquals(7, list_1.indexOf(100));
        list_1.insertToAnOrderList(5);
        assertEquals(5, list_1.get(5));
        assertEquals(5, list_1.get(6));
    }

    @Test
    void append() {

        list.append(10);
        list.append(11);
        assertEquals(2, list.size());
        assertEquals("[10,11]", list.toString());

    }

    @Test
    void get_size() {
        list.append(10);
        list.append(11);
        list.append(13);
        assertEquals(3, list.size());
    }

    @Test
    void recursive_display() {
        list_1.recursiveDisplay();
    }

    @Test
    void explicitCount() {
        assertEquals(5, list_1.explicitCounting());
        assertEquals(5, list_1.recursiveExplicitCount());

        assertEquals(1, list_2.explicitCounting());
        assertEquals(1, list_2.recursiveExplicitCount());

        assertEquals(0, list_3.explicitCounting());
        assertEquals(0, list_3.recursiveExplicitCount());
    }

    @Test
    void sumOfListContainsNumbers() {
        assertEquals(20, LinkedList.sum(list_1));
        assertEquals(1, LinkedList.sum(list_2));
        assertEquals(0, LinkedList.sum(list_3));
    }

    @Test
    void findMaxValue() {
        assertEquals(10, LinkedList.max(list_1));
        assertEquals(1, LinkedList.max(list_2));
        assertThrows(IllegalStateException.class, () -> LinkedList.max(list_3));
    }

    @Test
    void checkIfListContainsValue() {
        assertTrue(list_1.contains(10));
        assertFalse(list_1.contains(25));
        assertTrue(list_2.contains(1));
        assertFalse(list_2.contains(25));
        assertFalse(list_3.contains(20));
        assertFalse(list_3.contains(null));

    }

    @Test
    void getIndexOfListItem() {
        assertEquals(0, list_1.indexOf(1));
        assertEquals(1, list_1.indexOf(2));
        assertEquals(2, list_1.indexOf(3));
        assertEquals(4, list_1.indexOf(10));
        assertEquals(-1, list_1.indexOf(100));

        assertEquals(0, list_2.indexOf(1));
        assertEquals(-1, list_2.indexOf(100));

        assertEquals(-1, list_3.indexOf(100));
    }

    @Test
    void transpositionSearchByValue() {
        // assertEquals();
        int size = list_1.size();
        for (int i = 0; i < size + 10; i++) {

            int indexBeforeTheSearch = list_1.indexOf(10);
            assertTrue(list_1.transpositionByValueSearch(10));
            int indexAfterTheSearch = list_1.indexOf(10);
            int expectedIndex = indexBeforeTheSearch - 1;
            assertEquals(Math.max(expectedIndex, 0), indexAfterTheSearch);
        }
    }

    @Test
    void insertAtTest() {
        var list = new LinkedList<>(new Integer[] { 1, 2, 3 });
        assertEquals(list.toString(), "[1,2,3]");
        list.insertAt(99, 0);
        assertEquals(0, list.indexOf(99));
        assertEquals(1, list.indexOf(1));
        list.insertAt(80, list.size());
        assertEquals(list.size() - 1, list.indexOf(80));
        assertEquals(list.size() - 2, list.indexOf(3));
    }

    @Test
    void transpositionSearchByRef() {
        int size = list_1.size();
        for (int i = 0; i < size + 10; i++) {

            int indexBeforeTheSearch = list_1.indexOf(10);
            assertTrue(list_1.transpositionByRefSearch(10));
            int indexAfterTheSearch = list_1.indexOf(10);
            int expectedIndex = indexBeforeTheSearch - 1;
            assertEquals(Math.max(expectedIndex, 0), indexAfterTheSearch);
        }
    }
}