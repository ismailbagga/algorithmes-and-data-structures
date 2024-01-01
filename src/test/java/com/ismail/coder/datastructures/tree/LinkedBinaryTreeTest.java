package com.ismail.coder.datastructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinaryTreeTest {
    LinkedBinaryTree<Integer> emptyTree  ;
    LinkedBinaryTree<Integer> tree_1  ;

    @BeforeEach
    void setUp() {
        emptyTree = new LinkedBinaryTree<>(10) ;
        tree_1 = new LinkedBinaryTree<>(6) ;
        tree_1.addNode(10);
        tree_1.addNode(20);
        tree_1.addNode(30);
    }

    @Test
    void addNode() {
        emptyTree.addNode(10);
        emptyTree.addNode(20);
        emptyTree.addNode(30);
        emptyTree.addNode(40);
        assertEquals("[10,20,30,40]",emptyTree.toString());
    }

    @Test
    void preOrderTraversal() {
//        emptyTree.preOrderTraversal();
        tree_1.iterativePreOrderTraversal();
    }
}