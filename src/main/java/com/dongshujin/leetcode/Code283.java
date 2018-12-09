package com.dongshujin.leetcode;

public class Code283 {

    public void moveZeroes(int[] nums) {
        if(null == nums || 1 >= nums.length)
            return;
        int head = 0;
        int tail = nums.length-1;
        while (head < tail) {
            while (0 != nums[head]) {
                head++;
            }
            while (0 == nums[tail]) {
                tail--;
            }
            if (head<tail) {
                swap(nums, head, tail);
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (null == nums || 1>=nums.length)
            return;
        int zeroIdx = 0;
        int nonIdx = zeroIdx+1;
        while (zeroIdx < nums.length) {
            while (zeroIdx < nums.length && 0 != nums[zeroIdx]) {
                zeroIdx++;
            }
            if (zeroIdx >= nums.length)
                break;

            nonIdx = zeroIdx+1;
            while (nonIdx < nums.length && 0 == nums[nonIdx]) {
                nonIdx++;
            }
            if (nonIdx >= nums.length)
                break;

            swap(nums, zeroIdx, nonIdx);
        }


    }

    private void swap(int[] nums, int f1, int f2) {
        int tmp = nums[f1];
        nums[f1] = nums[f2];
        nums[f2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        new Code283().moveZeroes2(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

}
