package com.dongshujin.leetcode;

public class Code461 {

    public static int hammingDistance(int x, int y) {
        int num = x ^ y;
        int dis = 0;
        while (0 != num) {
            dis++;
            num = num & (num-1);
        }
        return dis;
    }

    public static void main(String[] args) {

        System.out.println(hammingDistance(4, 4));

    }


}
