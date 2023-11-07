package com.ismail.coder.datastructures.stack;

import com.ismail.coder.datastructures.list.LinkedList;

import java.util.EmptyStackException;

public class ListStack<T extends Comparable<T>> implements SimpleStack<T> {
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
        int size = list.size();
        if (index < 0 || index >= size)
            return null;
        var lastElementIndex = size - 1;
        var calculatedIndex = index - lastElementIndex;

        return list.get(Math.abs(calculatedIndex));
    }

    public T stackTop() {
        int size = list.size();
        if (size == 0)
            return null;
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public boolean isFull() {
        return list.size() == capacity;
    }

}
