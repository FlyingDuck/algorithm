package com.dongshujin.demo.algorithm;

/**
 * Created by dongsj on 16/11/30.
 */
public class Pow {

    public int pow(int x, int y) {
        if (x <=0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (1==x) {
            return 1;
        }
        if (1==y) {
            return x;
        }
        int tmp = pow(x, y/2);
        if ((y&1) == 1) { // x 为奇数
            return x*tmp*tmp;
        } else {
            return tmp*tmp;
        }
    }

    public static void main(String[] args) {
        int x = 3, y = 5;
        int result = new Pow().pow(x, y);
        System.out.println("X^Y : " + result);
    }

}
