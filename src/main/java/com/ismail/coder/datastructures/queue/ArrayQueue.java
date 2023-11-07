package com.ismail.coder.datastructures.queue;

import java.util.Arrays;

public class ArrayQueue<T>  implements Queue<T>{
    private final T[] data ;
    private int rear = -1 , front = -1 ;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        // When Need An Empty Space For isFull() to be true for size() == capacity
        // and isEmpty() to be true
        // while leaving the front pointer pointing at empty index to not let front == rear WHEN rear == front != -1
        this.data = (T[]) new  Object[capacity+1];
    }
    @Override
    public void enqueue(T value) {
        if (isFull()) throw new RuntimeException("Queue is full");
        rear = circularIndexing(rear+1);
        this.data[rear] = value ;
    }
    public int circularIndexing(int value) {
        return value % data.length ;
    }
    @Override
    public T dequeue() {
        if (isEmpty()) throw  new RuntimeException("Queue is empty");
        front = circularIndexing(front+1) ;
        var value = this.data[front];
        this.data[front] = null ;
        return value;
    }

    @Override
    public T peek() {
        var valueIndex = circularIndexing(front) ;
        return this.data[valueIndex];
    }


    @Override
    public T last() {
        return this.data[rear];
    }

    @Override
    public int size() {
        int size = data.length + rear - front ;
        return size >= data.length ? rear - front : size ;
    }

    @Override
    public boolean isFull() {
        return size() == data.length - 1  ;
    }

    @Override
    public boolean isEmpty() {
        return rear == front  ;
    }
    @Override
    public String toString() {
        return Arrays.toString(data) ;
    }
}