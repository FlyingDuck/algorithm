package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
 */
public class DP2 {

    public static int count(int n) {
        if (0 > n)
            return 0;
        if (0 == n)
            return 1;

        return count(n-1) + count(n-2) + count(n-3);
    }

    public static int count2(int dist) {
        if (dist <= 0)
            return 0;
        if (dist == 1)
            return 1;
        if (dist == 2)
            return 2;
        if (dist == 3)
            return 4;

        return count2(dist-1) + count2(dist-2) + count2(dist-3);
    }

    public static int count3(int dist) {
        int[] counts = new int[dist+1];
        counts[0] = 0;
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;


        for (int i=4; i<=dist; i++) {
            counts[i] = counts[i-3] + counts[i-2] + counts[i-1];
        }
        return counts[dist];
    }


    public static void main(String[] args) {

        System.out.println(count(5));
        System.out.println(count2(5));
        System.out.println(count3(5));
    }


}
