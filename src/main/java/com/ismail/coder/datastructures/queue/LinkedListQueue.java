package com.ismail.coder.datastructures.queue;

import java.util.ArrayList;

public class LinkedListQueue<T> implements Queue<T> {
    private final java.util.List<T> data = new ArrayList<>();
    private  int capacity ;

    public LinkedListQueue(int capacity) {
        if ( capacity <= 0) throw new IllegalArgumentException("capacity can not be less then or equal  0 ");
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T value) {
        if( isFull()) throw new RuntimeException("Queue is Full") ;
        data.add(value) ;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
       return  data.remove(0) ;
    }

    @Override
    public T peek() {
        return data.get(0);
    }

    @Override
    public T last() {
        return data.get(data.size()-1);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0 ;
    }
}
