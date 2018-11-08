package com.dongshujin.year2018.offer;

/**
 * 面试题10：二进制数中1的个数
 * 题目：
 */
public class Q10 {

    static int count(final int num) {
        int copyNum = num;

        int count = 0;
        while (copyNum != 0) {
            if ((copyNum & 1) == 1)
                count++;
            copyNum = copyNum >>> 1;
        }

        return count;
    }

    static int count1(final int num) {
        int factor = 1;

        int count = 0;
        while (factor != 0) {
            if ((num & factor) != 0)
                count++;
            factor = factor << 1;
        }
        return count;
    }

    static int count2(final int num) {
        int copyNum = num;

        int count = 0;
        while (copyNum != 0) {
            count++;

            copyNum = copyNum & (copyNum-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 11;
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count1(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count2(num));
        num = -11;
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count1(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count2(num));
        num = Integer.MAX_VALUE;
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count1(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count2(num));
        num = Integer.MIN_VALUE;
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count1(num));
        System.out.println( Integer.toBinaryString(num) + " | result = " + Q10.count2(num));
    }
}
