package com.ismail.coder.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ismail.coder.datastructures.stack.SimpleStack;
import com.ismail.coder.datastructures.stack.ArrayStack;


public class ArrayStackTest extends SimpleStackTests {


    @Override
    public SimpleStack<Integer> getSimpleStackImpl(int size) {
        return new ArrayStack<>(size);
    }
}