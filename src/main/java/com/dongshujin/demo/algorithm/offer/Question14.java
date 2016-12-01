package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.PrintUtils;

/**
 * Created by dongsj on 16/11/30.
 */
public class Question14 {

    /*
    调整数组顺序使奇数位于偶数的前面
    Q：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于整数的前半部分，所有偶数位于数组的后半部分。
    A：
     */

    public void reorderOddEven(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }

        int head = 0;
        int tail = array.length-1;

        while (head < tail) {
            while (head < tail && (array[head]&1)==1) {
                head++;
            }
            while (head < tail && (array[tail]&1)==0) {
                tail--;
            }
            if (head < tail) {
                int tmp = array[head];
                array[head] = array[tail];
                array[tail] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        Question14 question14 = new Question14();
        int[] array = new int[]{5, 6, 9, 2, 4, 7, 1};

        question14.reorderOddEven(array);

        PrintUtils.printArray(array);
    }

}
