package com.dongshujin.leetcode;

public class Code215 {

    public int findKthLargest(int[] nums, int k) {

        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = partition(nums, lo, hi);
            if (mid < k-1) {
                lo = mid+1;
            } else if (mid > k-1) {
                hi = mid -1;
            } else {
                break;
            }
        }
        return nums[k-1];
    }

    private void sort(int[] nums, int start, int end, int k) {
        if (start >= end)
            return;
        int mid = partition(nums, start, end);
        if (k-1 == mid)
            return;
        if (mid > start)
            sort(nums, 0, mid-1, k);
        if (mid < end)
            sort(nums, mid+1, end, k);
    }

    private int partition(int[] nums, int start, int end) {
        if (start >= end)
            return nums[start];

        int povItem = nums[end];
        int small = start-1;

        for (int i=start; i<end; i++) {
            if (nums[i] >= povItem)
                swap(nums, ++small, i);
        }

        swap(nums, ++small, end);
        return small;
    }

    private void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        int result = new Code215().findKthLargest(nums, k);
        System.out.println(result);

        nums = new int[]{3,2,3,1,2,4,5,5,6};
        k = 4;
        result = new Code215().findKthLargest(nums, k);
        System.out.println(result);

    }

}
