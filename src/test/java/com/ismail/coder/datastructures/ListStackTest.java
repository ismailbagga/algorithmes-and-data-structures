package com.ismail.coder.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import com.ismail.coder.datastructures.ADT.SimpleStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("List Stack Tests")
public class ListStackTest extends  SimpleStackTests{

    @Override
    public SimpleStack<Integer> getSimpleStackImpl(int size) {
        return new ListStack<>(size) ;
    }
}
