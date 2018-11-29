package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class DP12 {

    public static int count(int[] S, int N) {

        return count(S, S.length-1, N);
    }

    public static int count(int[] S, int m,int N) {


        return count(S, m-1, N) + count(S, m, N-S[m]);
    }
}
