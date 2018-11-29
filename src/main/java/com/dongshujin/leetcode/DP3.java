package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class DP3 {

    private static int lcs(char[] X, char[] Y) {
        return lcs(X, X.length-1, Y, Y.length-1);
    }

    private static int lcs(char[] X, int n, char[] Y, int m) {
        if (-1 == n || -1 == m)
            return 0;
        if (X[n] == Y[m])
            return lcs(X, n-1, Y, m-1) + 1;
        else
            return Math.max(
                    lcs(X, n-1, Y, m),
                    lcs(X, n, Y, m-1));
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1.toCharArray(), s2.toCharArray()));
    }


}
