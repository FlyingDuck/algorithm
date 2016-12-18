package com.dongshujin.demo.algorithm;

/**
 * Created by dongsj on 16/11/30.
 */
public class Pow {


    public double pow(int x, int y) {
        int absY = y;
        if (y < 0) {
            absY = -y;
        }

        int tmpResult = powFunc(x, absY);

        double result = tmpResult;
        if (y < 0) {
            result = 1.0/result;
        }
        return result;
    }


    private int powFunc(int x, int y) {
        if (x ==0 || y < 0) {
            throw new IllegalArgumentException();
        }
        if (1==x) {
            return 1;
        }
        if (1==y) {
            return x;
        }
        int tmp = powFunc(x, y/2);
        if ((y&1) == 1) { // x 为奇数
            return x*tmp*tmp;
        } else {
            return tmp*tmp;
        }
    }

    public static void main(String[] args) {
        int x = -2, y = -2;
        double result = new Pow().pow(x, y);
        System.out.println("X^Y : " + result);
    }

}
