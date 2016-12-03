package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question36 {

    /*
    数组中的逆序对
    Q：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求这个数组中的逆序对的总数。
    A：
     */

    public int inversePairs(int[] array) {
        if (null == array) {
            throw new IllegalStateException();
        }

        int[] copyArray = array.clone();

        return inversePairsCore(array, copyArray, 0, array.length-1);
    }


    private int inversePairsCore(int[] array, int[] copyArray, int start, int end) {

        if (start == end) {
            copyArray[start] = array[start];
            return 0;
        }

        int step = (end-start)/2;
        int left = inversePairsCore(copyArray, array, start, start+step);
        int right = inversePairsCore(copyArray, array, start+step+1, end);

        // 初始化前半段最后一个数字的下标
        int i = start+step;
        // 初始化为后半段最后一个数字的下标
        int j = end;

        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start+step+1) {
            if (array[i] > array[j]) {
                copyArray[indexCopy--] = array[i--];
                count += j-start-step;
            } else {
                copyArray[indexCopy--] = array[j--];
            }
        }

        for (; i>=start; i--) {
            copyArray[indexCopy--] = array[i];
        }

        for (; j >= start+step+1; j--) {
            copyArray[indexCopy--] = array[j];
        }

        return left+right+count;
    }

    public static void main(String[] args) {
        Question36 question36 = new Question36();

        int[] array = new int[]{7, 5, 6, 4};

        int sum = question36.inversePairs(array);
        System.out.print("result: " + sum);
    }




}
