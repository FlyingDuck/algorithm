package com.dongshujin.leetcode;

public class Code53 {
    public static int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sums[i] = Math.max(sums[i-1]+nums[i], nums[i]);
        }
        int max = sums[0];
        for (int i=1; i<sums.length; i++) {
            max = Math.max(sums[i], max);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            currentMax = Math.max(currentMax+nums[i], nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);

        result = maxSubArray2(nums);
        System.out.println(result);
    }
}
