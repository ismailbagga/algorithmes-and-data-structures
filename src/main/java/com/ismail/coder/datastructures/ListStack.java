package com.ismail.coder.datastructures;

import java.util.EmptyStackException;

public class ListStack<T extends Comparable<T>> {
    private int capacity;
    private LinkedList<T> list;

    public ListStack() {
    }

    public ListStack(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<T>();
    }

    public void push(T value) {
        if (list.size() == capacity)
            throw new StackOverflowError();
        // if I Dont Insert At Head The Removal (Pop) Will Take O(n)
        list.insertAtHead(value);
    }

    public T pop() {
        int size = list.size();
        if (size == 0)
            throw new EmptyStackException();
        var value = list.get(0);
        list.deleteAt(0);
        return value;
    }

    public T peek(int index) {
        // Stack Size Is The List Size
        // The Validation Is Done Internaly
        return list.get(index);
    }

    public T stackTop() {
        int size = list.size();
        if (size == 0)
            return null;
        return list.get(size - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        return list.size() == capacity;
    }

}
