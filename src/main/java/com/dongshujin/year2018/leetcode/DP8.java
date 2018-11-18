package com.dongshujin.year2018.leetcode;

/**
 * https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
 */
public class DP8 {

    private static int optimalStrategy(int[] arr) {
        return optimalStrategy(arr, 0, arr.length-1);
    }

    private static int optimalStrategy(int[] arr, int i, int j) {
        if (i > j)
            return 0;

        int result1 = arr[i] + Math.min(optimalStrategy(arr, i+2, j), optimalStrategy(arr, i+1, j-1));
        int result2 = arr[j] + Math.min(optimalStrategy(arr, i+1, j-1), optimalStrategy(arr, i,j-2));
        return Math.max(result1, result2);
    }


    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7 };
        System.out.println(optimalStrategy(arr1));

        int arr2[] = { 2, 2, 2, 2 };
        System.out.println(optimalStrategy(arr2));

        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        System.out.println(optimalStrategy(arr3));
    }
}
