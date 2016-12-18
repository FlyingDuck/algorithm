package com.dongshujin.demo.algorithm.offer;

import java.util.Stack;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question22 {
    /*
    栈的压入、弹出序列
    Q：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入的数字均不相等。例如压入序列为1、2、3、4、5，那么序列4、5、3、2、1是该压栈序列的一个弹出序列，但是4、3、5、1、2就不可能是弹出序列。
    A：
     */


    private Stack<Integer> initStack(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int num : array) {
            stack.push(num);
        }
        return stack;
    }

    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        Stack<Integer> stack = new Stack<Integer>();

        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < pushOrder.length || !stack.isEmpty()) {
            // 判断栈顶元素是否是当前出栈元素
            // 1，是当前出栈元素 则出栈
            // 2，不是当前出栈元素 则继续入栈
            if (!stack.isEmpty() && stack.peek() == popOrder[popIndex]) { // 是当前元素，出栈
                stack.pop();
                popIndex++;
            } else {
                // 执行压栈
                if (pushIndex < pushOrder.length) {
                    stack.push(pushOrder[pushIndex++]);
                } else { // 当前栈顶元素和出栈元素不相同 并且已经没有入栈元素时
                   break;
                }

            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Question22 question22 = new Question22();
        int[] pushOrder = new int[]{1,2,3,4,5};
        int[] popOrder = new int[]{4,5,3,2,1};
        boolean result = question22.isPopOrder(pushOrder, popOrder);
        System.out.println("result : " + result);
    }

}
