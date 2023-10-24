package com.ismail.coder.datastructures;

public class ArrayStack {
    private int capacity;
    private int size = 0;
    private int[] data;

    public ArrayStack() {
        this(16);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }
}
