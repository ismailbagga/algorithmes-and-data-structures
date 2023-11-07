package com.ismail.coder.datastructures.stack;

public interface SimpleStack<T extends  Comparable<T>> {
    public void push(T value) ;
    public T pop()  ;

    public T peek(int index) ;
    public T stackTop()  ;

    public boolean isEmpty() ;

    public boolean isFull() ;
}
