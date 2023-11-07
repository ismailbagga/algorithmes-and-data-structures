package com.ismail.coder.datastructures.queue;

public class ArrayQueueTests extends  QueueTests{
    @Override
    Queue<Integer> getQueueImpl(int capacity) {
        return new ArrayQueue<>(capacity) ;
    }
}
