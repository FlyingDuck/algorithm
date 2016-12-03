package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question31 {

    /*
    连续子数组的最大和
    Q：输入一个整形数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
    A：
     */

    public int findGrestestSumOfSubArray(int[] array) {
        if (null == array) {
            throw new IllegalStateException();
        }


        int curSum = 0;
        int greatestSum = 0;
        int start=0, end=0;
        for (int i=0; i<array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
                start = i;
            } else {
                curSum += array[i];
            }

            if (curSum > greatestSum) {
                end = i;
                greatestSum = curSum;
            }
        }

        System.out.println("["+start+","+end+"]");

        return greatestSum;
    }


    public static void main(String[] args) {
        Question31 question31 = new Question31();

        int[] array = new int[]{1, -2, 3, 10, -4, 7, 2, -5};

        int result = question31.findGrestestSumOfSubArray(array);
        System.out.println("result: " + result);
    }


}
