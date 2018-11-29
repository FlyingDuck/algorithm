package com.dongshujin.leetcode;

public class DP13 {

    public static int maxProd(int len) {
        if (0 == len)
            return 0;
        if (1 == len)
            return 0;

        int max = 0;
        for (int i = 2; i < len; i++) {
            max = Math.max(
                    max,
                    Math.max(
                            i * (len - i),
                            maxProd(len - i) * i)
            );
        }
        return max;
    }
}
