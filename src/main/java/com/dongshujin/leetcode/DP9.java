package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class DP9 {

    public static int knapSack(int capacity, int[] wt, int[] val) {
        return knapSack(capacity, wt, val, val.length-1);
    }

    private static int knapSack(int capacity, int[] wt, int[] val, int i) {
        if (capacity <= 0)
            return 0;
        if (i == -1)
            return 0;

        if (wt[i] > capacity)
            return knapSack(capacity, wt, val, i-1);
        else {
            int choice1 = val[i] + knapSack(capacity-wt[i], wt, val,i-1);
            int choice2 = knapSack(capacity, wt, val, i-1);
            return Math.max(choice1, choice2);
        }
    }


    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        System.out.println(knapSack(W, wt, val));
    }



}
