package com.ismail.coder.datastructures.tree;

import com.ismail.coder.datastructures.queue.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Stack;

public class LinkedBinaryTree<T> implements Tree<T> {
    final class Node<T> {
        public T value;
        public Node<T> leftNode;
        public Node<T> rightNode;

        public Node(T value, Node<T> leftNode, Node<T> rightNode) {
            this.value = value;
            this.rightNode = rightNode;
            this.leftNode = leftNode;
        }
    }

    private Node<T> root;
    private final int capacity;
    private int size = 0;

    public LinkedBinaryTree(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity Could Not Be Less or equal to zero");
        this.capacity = capacity;
    }

    public void addNode(T value) {
        if (size >= capacity) throw new RuntimeException("Tree is full");
        if (root == null) {
            root = new Node<>(value, null, null);
            return;
        }
        java.util.ArrayDeque<Node<T>> queue = new ArrayDeque<>(capacity);
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.leftNode == null) {
                node.leftNode = new Node<>(value, null, null);
                return;
            }
            if (node.rightNode == null) {
                node.rightNode = new Node<>(value, null, null);
                return;
            }
            queue.add(node.leftNode);
            queue.add(node.rightNode);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void iterativePreOrderTraversal() {
        java.util.Stack<Node<T>> stack = new Stack<>();
        var curr = root ;
        while (!stack.isEmpty() || curr != null) {
            if ( curr == null ) {
                curr = stack.pop().rightNode ;
            }
            else {
                System.out.println(curr.value);
                stack.add(curr) ;
                curr = curr.leftNode ;
            }
        }
    }

    private void preOrderTraversal(Node<T> node) {
        if (node == null) return;
        System.out.println(node.value);
        preOrderTraversal(node.leftNode);
        preOrderTraversal(node.rightNode);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node == null) return;
        preOrderTraversal(node.leftNode);
        System.out.println(node.value);
        preOrderTraversal(node.rightNode);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node == null) return;
        preOrderTraversal(node.leftNode);
        preOrderTraversal(node.rightNode);
        System.out.println(node.value);
    }
    public int  getTreeHeight() {
        return getTreeHeight(root) ;
    }
    private int getTreeHeight(Node<T> node) {
        if ( node == null ) return 0 ;
        int x = getTreeHeight(node.leftNode);
        int y = getTreeHeight(node.rightNode);
        return Math.max(x, y) + 1  ;
    }
    @Override
    public String toString() {
        var builder = new StringBuilder("[");
        if (root != null) {
            java.util.Queue<Node<T>> queue = new ArrayDeque<>(capacity);
            queue.add(root);
            while (!queue.isEmpty()) {
                var node = queue.poll();
                builder = builder.append(node.value).append(',');
                if (node.leftNode != null) queue.add(node.leftNode);
                if (node.rightNode != null) queue.add(node.rightNode);

            }
        }
        return builder.deleteCharAt(builder.lastIndexOf(",")).append("]").toString();
    }

}

