package com.ismail.coder.datastructures.ADT;

import java.util.EmptyStackException;

public interface SimpleStack<T extends  Comparable<T>> {
    public void push(T value) ;
    public T pop()  ;

    public T peek(int index) ;
    public T stackTop()  ;

    public boolean isEmpty() ;

    public boolean isFull() ;
}
