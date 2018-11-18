package com.dongshujin.year2018.leetcode;

/**
 * https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class DP10 {

    public static int cutRod(int[] price) {
        return cutRod(price, price.length);
    }

    public static int cutRod(int[] price, int len) {
        if (0 >= len)
            return 0;
        if (1 == len)
            return price[0];

        int max = -1;
        for (int i=0; i<len; i++) {
            max = Math.max(max, price[i]+cutRod(price, len-1-i));
        }
        return max;
    }


    public static void main(String[] args) {
        int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(cutRod(price));
    }








}
