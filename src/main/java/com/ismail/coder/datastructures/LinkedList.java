package com.ismail.coder.datastructures;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class LinkedList<T extends Comparable<T>> {
    ListNode<T> head;
    ListNode<T> tail;
    private int size;

    static class ListNode<V> {
        public V value;
        public ListNode<V> next;

        public ListNode(V value, ListNode<V> next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(V value) {
            this(value, null);
        }
    }

    public LinkedList() {
    }

    public LinkedList(T[] array) {
        int length = array.length;
        if (length < 1) return;
        tail = head = new ListNode<T>(array[0]);
        for (int i = 1; i < length; i++) {
            tail.next = new ListNode<T>(array[i]);
            tail = tail.next;
        }
        size = length;
    }

    public int indexOf(T value) {
        var curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.value.equals(value)) return index;
            index++;
            curr = curr.next;

        }
        return -1;
    }

    public boolean transpositionByValueSearch(T value) {
        var curr = head;
        ListNode<T> prev = null;

        while (curr != null) {
            if (curr.value.equals(value)) {
                if (prev == null) return true;
                curr.value = prev.value;
                prev.value = value;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public boolean transpositionByRefSearch(T value) {
        var curr = head;
        ListNode<T> prev = null;
        ListNode<T> prevOfPrev = null;

        while (curr != null) {
            if (curr.value.equals(value)) {
                if (prev == null) return true;
                prev.next = curr.next;
                curr.next = prev;
                if (prevOfPrev == null) head = curr;

                else prevOfPrev.next = curr;
                return true;
            }
            prevOfPrev = prev;
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public boolean contains(T value) {
        var curr = head;
        while (curr != null) {
            if (curr.value.equals(value)) return true;
            curr = curr.next;
        }
        return false;
    }

    public void append(T value) {
        var node = new ListNode<T>(value);
        if (tail != null) {
            tail.next = node;
        } else head = node;
        tail = node;
        size++;
    }

    public String toString() {
        var builder = new StringBuilder("[");
        ListNode<T> curr = head;
        while (curr != null) {
            builder = builder.append(curr.value).append(',');
            curr = curr.next;
        }
        if (builder.charAt(builder.length() - 1) == ',') builder = builder.deleteCharAt(builder.length() - 1);
        return builder.append(']').toString();

    }

    public void display() {
        display(head);

    }

    public void recursiveDisplay() {
        recursiveDisplay(head);
    }

    private void display(ListNode<T> node) {
        var curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;

        }
    }

    private void recursiveDisplay(ListNode<T> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        recursiveDisplay(node.next);
    }

    public int size() {
        return size;
    }

    public int explicitCounting() {
        int count;
        ListNode<T> curr;
        for (count = 0, curr = head; curr != null; curr = curr.next, count++) ;
        return count;
    }

    public int recursiveExplicitCount() {
        return recursiveExplicitCount(head);
    }

    public int recursiveExplicitCount(ListNode<T> node) {
        if (node == null) return 0;
        return 1 + recursiveExplicitCount(node.next);

    }

    public static <V extends Number & Comparable<V>> double sum(LinkedList<V> list) {
        double total = 0;
        var curr = list.head;
        while (curr != null) {
            total += curr.value.doubleValue();
            curr = curr.next;
        }
        return total;
    }

    public static <V extends Number & Comparable<V>> V max(LinkedList<V> list) {
        if (list.size == 0) throw new IllegalStateException("array must be more than one");
        V maxValue = list.head.value;
        var curr = list.head.next;
        while (curr != null) {
            if (maxValue.compareTo(curr.value) < 0) maxValue = curr.value;
            curr = curr.next;
        }
        return maxValue;
    }

}
