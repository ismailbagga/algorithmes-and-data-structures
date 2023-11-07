package com.ismail.coder.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ArrayStackTest extends SimpleStackTests {


    @Override
    public SimpleStack<Integer> getSimpleStackImpl(int size) {
        return new ArrayStack<>(size);
    }
}