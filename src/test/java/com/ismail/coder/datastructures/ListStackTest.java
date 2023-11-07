package com.ismail.coder.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ismail.coder.datastructures.stack.SimpleStack;
import com.ismail.coder.datastructures.stack.ListStack;
import org.junit.jupiter.api.DisplayName;

@DisplayName("List Stack Tests")
public class ListStackTest extends  SimpleStackTests{

    @Override
    public SimpleStack<Integer> getSimpleStackImpl(int size) {
        return new ListStack<>(size) ;
    }
}
