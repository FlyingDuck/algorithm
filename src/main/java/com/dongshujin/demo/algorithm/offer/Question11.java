package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/30.
 */
public class Question11 {

    /*
    数值的整数次方
    Q：实现函数 double power(double base, int exponent)，求base的exponent次方。不能使用库函数，同时不需要考虑大数问题。
    A：
     */

    public double power(double base, int exponent) {
        if (equals(base, 0.00) && exponent <= 0) {
            throw new UnsupportedOperationException();
        }

        int absExponent = exponent;
        if (exponent<0) {
            absExponent = -exponent;
        }

        //double result = powerWithUnsignedExponent(base, exponent);
        double result = powerWithUnsignedExponent2(base, exponent);

        if (exponent<0) {
            result = 1.0/result;
        }
        return result;
    }

    private double powerWithUnsignedExponent(double base, int exponent) {
        double result = 0.0;
        for (int i=0; i<exponent; i++) {
            result *= base;
        }
        return result;
    }

    private double powerWithUnsignedExponent2(double base, int exponent) {
        if (0 == exponent) {
            return 1;
        }
        if (1 == exponent) {
            return base;
        }
        double result = powerWithUnsignedExponent2(base, exponent>>1);
        result *= result;
        if ((exponent&1)==1) {
            result *= base;
        }
        return result;
    }

    private boolean equals(double num1, double num2) {
        if (num1 - num2 < 0.0000001 && num2 - num1 > -0.0000001) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Question11 question11 = new Question11();
        double result = 0.0;
        result = question11.power(2.1, 4);

        System.out.println("result: " + result);
    }
}
