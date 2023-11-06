package com.ismail.coder.datastructures;

import com.ismail.coder.datastructures.ADT.SimpleStack;

import java.util.EmptyStackException;

public class ArrayStack<T extends  Comparable<T>> implements SimpleStack<T> {
    private final int capacity;
    private int size = 0;
    private T[] data;

    public ArrayStack() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        this.data = (T[])   new Comparable[capacity];
    }

    public void push(T value) {
        if (size >= capacity)
            throw new StackOverflowError();
        data[size++] = value;
    }

    public T stackTop() {
        if (size == 0)
            return null;
        return data[size - 1];

    }

    public T pop() {
        if (size == 0)
            throw new EmptyStackException();
        var value = data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public T peek(int index) {
        if (index < 0 || index >= size)
            return null ;
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
