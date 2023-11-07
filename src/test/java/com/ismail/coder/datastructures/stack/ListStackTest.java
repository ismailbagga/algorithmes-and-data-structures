package com.ismail.coder.datastructures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;

@DisplayName("List Stack Tests")
public class ListStackTest extends SimpleStackTests {

    @Override
    public SimpleStack<Integer> getSimpleStackImpl(int size) {
        return new ListStack<>(size) ;
    }
}
