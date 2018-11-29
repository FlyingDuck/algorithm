package com.dongshujin.leetcode;

import java.util.LinkedList;

public class MinStack {
    private int size;
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        size = 0;
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.addFirst(x);
        // minStack
        Integer top = size>0 ? minStack.getFirst() : null;
        if (null == top)
            minStack.addFirst(x);
        else {
            if (x < top)
                minStack.addFirst(x);
            else
                minStack.addFirst(top);
        }
        size++;
    }

    public void pop() {
        if (size <= 0)
            return;
        size--;
        stack.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }

}
