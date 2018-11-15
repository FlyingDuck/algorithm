package com.dongshujin.year2018.leetcode;

public class Code169 {

    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int times = 1;
        for (int i=1; i<nums.length; i++) {
            if (majority == nums[i])
                times++;
            else {
                times--;
                if (times == 0) {
                    majority = nums[i];
                    times = 1;
                }
            }
        }
        return majority;
    }

    public int majorityElement2(int[] nums) {

        int mid = -1;
        while (mid < nums.length/2) {
            if ((mid+1)>=nums.length-1)
                return nums[mid+1];
            mid = partition(nums, mid+1, nums.length-1);
        }
        return nums[mid-1];
    }

    private int partition(int[] nums, int start, int end) {
        int mark = nums[end];

        int small = start-1;
        for (int i=start; i<end; i++) {
            if (nums[i] < mark) {
                swap(nums, ++small, i);
            }
        }

        swap(nums, ++small, end);
        return small;
    }

    private void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3};
        int result = new Code169().majorityElement2(nums);
        System.out.println(result);
    }

}
