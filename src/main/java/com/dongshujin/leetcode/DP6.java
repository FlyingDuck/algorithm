package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/shortest-common-supersequence/
 *
 * same as
 *
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class DP6 {

    public static int scs(char[] X, char[] Y) {
        int lcs = lcs(X, X.length-1, Y, Y.length-1);
        return X.length + Y.length - lcs;
    }



    public static int lcs(char[] X, int i, char[] Y, int j) {
        if (-1 == i || -1 == j)
            return 0;

        if (X[i] == Y[j])
            return 1 + lcs(X, i-1, Y, j-1);
        else {
            return Math.max(
                    lcs(X, i, Y, j-1),
                    lcs(X, i-1, Y, j));
        }
    }


    public static void main(String[] args) {
        String str1 = "geek";
        String str2 = "eke";
        System.out.println(scs(str1.toCharArray(), str2.toCharArray()));


        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(scs(X.toCharArray(), Y.toCharArray()));
    }

}
