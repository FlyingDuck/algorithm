package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/30.
 */
public class Question9 {

    /*
    斐波拉契数列
    Q：写一个函数，输入n，求斐波拉契(Fibonacci)数列的第n项。
    A：
     */

    public long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        System.out.println("fibonacci");
        return fibonacci(n-1) + fibonacci(n-2);
    }

    /**
     * 带缓存的fibonacci
     * @param n
     * @param cache
     * @return
     */
    public long fibonacci(int n, long[] cache) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            cache[1] = 1;
            return 1;
        }

        if (cache[n] != 0) {
            System.out.println("cache: " + n);
            return cache[n];
        }

        System.out.println("fibonacci");
        long sum = fibonacci(n-1, cache) + fibonacci(n-2, cache);
        cache[n] = sum;

        return sum;
    }

    public long fibonacci2(int n) {
        int[] result = new int[]{0, 1};
        if (n < 2) {
            return result[n];
        }

        long fibN_1 = 1;
        long fibN_2 = 0;
        long fibN = 0;
        for (int i=2; i<=n; i++) {
            fibN = fibN_1 + fibN_2;

            fibN_2 = fibN_1;
            fibN_1 = fibN;
        }
        return fibN;
    }



    public static void main(String[] args) {
        int n = 4;
        long result = 0;

        Question9 question9 = new Question9();
//        result = question9.fibonacci(n);


//        long[] cache = new long[n+1];
//        cache[0] = 0;
//        cache[1] = 1;
//        result = question9.fibonacci(n, cache);

        result = question9.fibonacci2(n);

        System.out.println("result: " + result);
    }
}
