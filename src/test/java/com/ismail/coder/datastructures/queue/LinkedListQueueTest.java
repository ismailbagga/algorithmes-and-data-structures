package com.ismail.coder.datastructures.queue;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueTest extends QueueTests{

    @Override
    Queue<Integer> getQueueImpl(int capacity) {
        return new LinkedListQueue<>(capacity);
    }
}