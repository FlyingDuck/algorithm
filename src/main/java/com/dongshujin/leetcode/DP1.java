package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 */
public class DP1 {

    public int findMin(int[] arr) {
        if (null == arr)
            return 0;
        if (1 == arr.length)
            return arr[0];
        if (2 == arr.length)
            return Math.abs(arr[0]-arr[1]);

        int sum = 0;
        for (int i=0; i<arr.length; i++)
            sum += arr[i];

        return findMin(arr, sum, 0, arr.length-1);

    }

    /*private int findMin(int[] arr, int sum, int subSum, int i) {
        if (0 == i)
            return Math.abs(sum-subSum-subSum);
        return Math.min(
                findMin(arr, sum, subSum+arr[i-1], i-1),
                findMin(arr, sum, subSum, i-1)
        );
    }*/

    private int findMin(int[] arr, int sum, int subSum, int i) {
        if (-1 == i)
            return Math.abs(sum-subSum-subSum);
        return Math.min(
                findMin(arr, sum, subSum+arr[i], i-1),
                findMin(arr, sum, subSum, i-1)
        );
    }

    public static void main(String[] args) {
//        int arr[] = {1, 6, 11, 5} ;
        int arr[] = {3, 1, 4, 2, 2, 1} ;
        System.out.println(new DP1().findMin(arr));
    }

}
