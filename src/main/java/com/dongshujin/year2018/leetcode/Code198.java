package com.dongshujin.year2018.leetcode;

import java.util.Arrays;

public class Code198 {

    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length)
            return 0;

        int[] memo = new int[nums.length+1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i=1; i<nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }
        return memo[nums.length];
    }


    int[] memo;
    public int rob2(int[] nums) {
        if (null == nums || 0 == nums.length)
            return 0;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return rob2(nums, nums.length-1);
    }

    public int rob2(int[] nums, int i) {
        if (i<0)
            return 0;
        if (memo[i] >= 0)
            return memo[i];

        int val = Math.max(nums[i]+rob2(nums, i-2), rob2(nums, i-1));
        memo[i] = val;
        return val;
    }

}
