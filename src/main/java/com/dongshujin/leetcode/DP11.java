package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 */
public class DP11 {

    public static boolean canbePartition(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if ((sum & 1) != 0) {
            return false;
        }

        return canbePartition(nums, nums.length-1,sum/2);
    }

    private static boolean canbePartition(int[] nums, int i,int halfSum) {
        if (0 == halfSum)
            return true;
        if (-1 == i && 0 != halfSum)
            return false;

        if (nums[i] > halfSum)
            return canbePartition(nums, i-1, halfSum);

        return canbePartition(nums, i-1, halfSum-nums[i]) || canbePartition(nums, i-1, halfSum);
    }


    public static void main(String[] args) {
        int arr[] = {3, 1, 5, 9, 12};
        System.out.println(canbePartition(arr));

        arr = new int[]{3, 1, 5, 9, 13};
        System.out.println(canbePartition(arr));
    }

}
