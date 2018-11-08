package com.dongshujin.year2018.offer;

/**
 * 面试题9： 斐波那契数列
 */
public class Q9 {

    static int fibonacci(int n) {
        if (n <= 0)
            throw new IllegalArgumentException(); // IAE
        if (1 == n)
            return 1;
        if (2 == n)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    static int fibonacci1(int n, int[] cache) {
        if (n <= 0)
            throw new IllegalArgumentException(); // IAE
        if (1 == n)
            return 1;
        if (2 == n)
            return 1;

        if (cache[n] != 0)
            return cache[n];

        cache[n] = fibonacci1(n-1, cache) + fibonacci1(n-2, cache);
        return cache[n];
    }


    public static void main(String[] args) {

        int result = Q9.fibonacci(10);
        System.out.println("result = " + result);

        result = Q9.fibonacci1(10, new int[10+1]);
        System.out.println("result = " + result);

    }
}
