package com.ismail.coder.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {

    private ArrayStack<Integer> emptyStack, fullStack;

    @BeforeEach
    public void setUp() {
        emptyStack = new ArrayStack<>(1);
        fullStack = new ArrayStack<>(3);
        fullStack.push(1);
        fullStack.push(2);
        fullStack.push(3);
    }

    @Test
    @DisplayName("Pushing Values From The Stack")
    public void pushValue() {
        assertTrue(emptyStack.isEmpty());
        emptyStack.push(10);
        assertThrows(StackOverflowError.class, () -> fullStack.push(100));
        assertTrue(emptyStack.isFull());
    }

    @Test
    @DisplayName("Pulling Values From The Stack")
    public void pullValue() {
        assertEquals(3, fullStack.pop());
        assertEquals(2, fullStack.pop());
        assertEquals(1, fullStack.pop());
        assertTrue(fullStack.isEmpty());
        assertThrows(EmptyStackException.class, () -> fullStack.pop());
        assertThrows(EmptyStackException.class, () -> fullStack.pop());
    }
}