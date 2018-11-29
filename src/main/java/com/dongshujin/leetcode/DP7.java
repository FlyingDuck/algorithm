package com.dongshujin.leetcode;

/**
 * https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 *
 */
public class DP7 {

    private static int findLongest(int[][] mat) {
        int[][] dp = new int[mat.length][mat.length];
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int result = 1;
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (-1 == dp[i][j])
                    findLongest(mat, i, j, dp);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }


    private static int findLongest(int[][] mat, int i, int j, int[][] dp) {
        if (i<0 || i>=mat.length || j<0 || j>=mat[0].length)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        // 4 directions
        if (i+1 < mat.length && (mat[i+1][j] == mat[i][j]+1)) {
            dp[i][j] = 1 + findLongest(mat, i+1, j, dp);
            return dp[i][j];
        }

        if (i-1 >= 0 && (mat[i-1][j] == mat[i][j] +1)) {
            dp[i][j] = 1 + findLongest(mat, i-1, j, dp);
            return dp[i][j];
        }

        if (j+1 < mat[0].length && (mat[i][j+1] == mat[i][j]+1)) {
            dp[i][j] = 1 + findLongest(mat, i, j+1, dp);
            return dp[i][j];
        }

        if (j-1 >= 0 && (mat[i][j-1] == mat[i][j] +1)) {
            dp[i][j] = 1 + findLongest(mat, i, j-1, dp);
            return dp[i][j];
        }

        dp[i][j] = 1;
        return 1;
    }


    public static void main(String[] args) {
        int  mat[][] = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };

        System.out.println(findLongest(mat));
    }

}
