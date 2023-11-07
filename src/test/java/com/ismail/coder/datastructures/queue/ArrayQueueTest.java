package com.ismail.coder.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    Queue<Integer> queue;
    final int QUEUE_CAPACITY = 5 ;

    public Queue<Integer> getQueueImpl(int capacity) {
        return new ArrayQueue<>(capacity);
    }

    @BeforeEach()
    public void setUp() {
        queue = getQueueImpl(QUEUE_CAPACITY);
    }

    @Test
    void enqueueTesting() {
        assertEquals(0, queue.size());
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        assertEquals(QUEUE_CAPACITY, queue.size());
        assertThrows(RuntimeException.class, () -> queue.enqueue(60));
    }

    @Test
    void dequeueTesting() {
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
           queue.enqueue(i+1);
        }
        assertEquals(QUEUE_CAPACITY,queue.size());
        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());
        for (int i = 0; i < QUEUE_CAPACITY; i++) {
            assertEquals(i+1,queue.dequeue());
        }
        assertEquals(0,queue.size());
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
        System.out.println(queue);
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i+1);
        }
        assertThrows(RuntimeException.class,() ->queue.enqueue(100));
        assertEquals(1,queue.dequeue());
        assertEquals(2,queue.dequeue());
        queue.enqueue(100);
        queue.enqueue(200);
        assertThrows(RuntimeException.class,() ->queue.enqueue(300));
        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());
        assertEquals(5,queue.size());
        System.out.println(queue);
    }
}