package com.ismail.coder.datastructures.queue;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();

    T peek() ;
    T last() ;
    int size()  ;
    boolean isFull();
    boolean isEmpty();
}
