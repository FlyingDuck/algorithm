package com.dongshujin.leetcode;

public class Code70 {
    public static int climbStairs(int n) {
        if (n<=0)
            return 0;
        if (1 == n)
            return 1;
        int[] memory = new int[n+1];
        memory[0] = 0;
        memory[1] = 1;
        memory[2] = 2;
        return climbStairs(n, memory);
    }

    public static int climbStairs(int n, int[] memory) {
        if (0 != memory[n])
            return memory[n];
        int result = climbStairs(n-1, memory) + climbStairs(n-2, memory);
        memory[n] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
//        System.out.println(climbStairs(2));
//        System.out.println(climbStairs(3));
//        System.out.println(climbStairs(4));

    }


}
