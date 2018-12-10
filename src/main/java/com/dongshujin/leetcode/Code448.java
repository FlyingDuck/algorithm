package com.dongshujin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i=0; i< nums.length; i++) {
            int value = nums[i];
            while (value != i+1) {
                int realIdx = value - 1;
                if (nums[realIdx] != value) {
                    swap(nums, i, realIdx);
                } else {
                    break;
                }
                value = nums[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (i+1 != nums[i])
                result.add(i+1);
        }
        return result;
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = new Code448().findDisappearedNumbers(nums);
        for (Integer item : result) {
            System.out.print(item + ",");
        }
    }
}
