package com.dongshujin.demo.algorithm.offer;

import java.util.Stack;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question21 {

    /*
    包含min函数的栈
    Q：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在栈中，调用min、push及pop的时间复杂度都是O(1)
    A：
     */

    public static class MinStack<T extends Comparable> {
        public Stack<T> dataStack; // 记录数据
        public Stack<T> minStack; // 记录最小值数据

        public MinStack() {
            dataStack = new Stack<T>();
            minStack = new Stack<T>();
        }

        // 当前元素与最小栈顶元素比较，
        // 1，小于最小栈顶元素，则将当前值入最小栈
        // 2，不小于最小栈顶元素，则将最小栈栈顶元素再次入栈
        public T push(T data) {
            if (minStack.isEmpty()) {
                minStack.push(data);
            } else {
                T min = minStack.peek();
                if (min.compareTo(data) == 1) {
                    minStack.push(data);
                } else {
                    minStack.push(min);
                }
            }

            return dataStack.push(data);
        }

        public T pop() {
            minStack.pop();
            return dataStack.pop();
        }

        public T min() {
            return minStack.peek();
        }

    }


    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<Integer>();
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);


        System.out.println("min: " + minStack.min());
        System.out.println(">>> pop: " + minStack.pop());

        System.out.println("min: " + minStack.min());
        System.out.println(">>> pop: " + minStack.pop());

        System.out.println("min: " + minStack.min());
        System.out.println(">>> pop: " + minStack.pop());

        System.out.println("min: " + minStack.min());
        System.out.println(">>> pop: " + minStack.pop());

        System.out.println("min: " + minStack.min());
        System.out.println(">>> pop: " + minStack.pop());
    }



}
