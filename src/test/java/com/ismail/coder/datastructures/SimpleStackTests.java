package com.ismail.coder.datastructures;

import com.ismail.coder.datastructures.stack.SimpleStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class SimpleStackTests {

    private SimpleStack<Integer> emptyStack, fullStack;
    private  SimpleStack<Integer> simpleStackImplementation ;
    public abstract SimpleStack<Integer> getSimpleStackImpl(int size) ;
    @BeforeEach
    public void setUp() {
        emptyStack = this.getSimpleStackImpl(1);
        fullStack = this.getSimpleStackImpl(3);
        fullStack.push(1);
        fullStack.push(2);
        fullStack.push(3);
    }

    @Test
    @DisplayName("Pushing Values To The Stack")
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

    @Test
    @DisplayName("Peeking Values From The Stack")
    public void peekingValue() {
        assertEquals(3, fullStack.peek(2));
        assertEquals(2, fullStack.peek(1));
        assertEquals(1, fullStack.peek(0));
        assertNull(fullStack.peek(3));
    }
}
