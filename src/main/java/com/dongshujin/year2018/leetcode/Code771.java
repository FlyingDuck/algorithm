package com.dongshujin.year2018.leetcode;

public class Code771 {

    public static int numJewelsInStones(String J, String S) {
        if (null == J || "".equals(J))
            return 0;
        if (null == S || "".equals(S))
            return 0;

        char[] j = J.toCharArray();
        char[] s = S.toCharArray();
        int result = 0;
        for (int m=0; m<j.length; m++) {
            for (int n=0; n<s.length; n++) {
                if (j[m] == s[n])
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";

        int result = numJewelsInStones(J, S);
        System.out.println(result);
    }



}
