package com.dongshujin.demo.algorithm.utils;

/**
 * Created by dongsj on 16/11/30.
 */
public class PrintUtils {

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    public static void printArray(char[] array) {
        for (char ch : array) {
            System.out.print(" " + ch);
        }
        System.out.println();
    }
}
