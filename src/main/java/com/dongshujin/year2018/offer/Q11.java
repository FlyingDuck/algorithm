package com.dongshujin.year2018.offer;

/**
 * 面试题11：数值的整数次方
 */
public class Q11 {

    static double pow(double x, int y) {
        if (x == 1)
            return 1;
        if (x == 0 && y <= 0)
            throw new IllegalArgumentException("Illegal y when x==0"); // IAE

        int absY = y;
        if (y < 0)
            absY = -y;

        if (absY == 1)
            return x;

        double tmp = pow(x, absY/2);
        double result = tmp*tmp;
        if ((y & 1) != 0)
            result *= x;
        if (y < 0)
            return 1/ result;
        return result;
    }

    private boolean approximateZero(double x) {
        if (x < 0.00000001 && x > -0.00000001)
            return true;
        return false;
    }


    public static void main(String[] args) {

        System.out.println(Q11.pow(2, 2));
        System.out.println(Q11.pow(2, -2));
    }

}
