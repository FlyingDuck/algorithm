package com.dongshujin.year2018.leetcode;

public class Code300_DP {

    public int lengthOfLIS(int[] nums) {
        if (null == nums)
            return 0;
        if (0 == nums.length)
            return 0;
        if (1 == nums.length)
            return 1;

        int[] len = new int[nums.length];
        len[0] = 1;
        int result = len[0];
        for (int i=1; i<nums.length; i++) {
            int maxval = 0;
            for (int j=0; j<i; j++)
                if (nums[i] > nums[j])
                    maxval = Math.max(len[j], maxval);
            len[i] = maxval + 1;
            result = Math.max(result, len[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };

        int result = new Code300_DP().lengthOfLIS(arr);

        System.out.println(result);
    }
}
