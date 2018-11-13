package com.dongshujin.year2018.offer;

/**
 *
 */
public class Q12 {

    static void print(int n) {
        char[] num = new char[n];
        for (int i=0; i<num.length; i++)
            num[i] = '0';

        while (incr(num)) {
            printNum(num);
        }
    }

    static boolean incr(char[] num) {

        int carry = 1;
        for (int i=num.length-1; i >= 0 && carry != 0; i--) {
            int digit = num[i] - '0';
            digit += carry;
            if (digit > 9) {
                digit = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            num[i] = (char) ('0' + digit);
        }

        return carry == 0;
    }

    static void printNum(char[] num) {

        boolean start = false;
        for (int i=0; i < num.length; i++) {
            if (num[i] == '0' && !start) {
                continue;
            }
            start = true;
            System.out.print(num[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        /*char[] num = new char[]{'0', '0', '0', '1', '0', '2'};

        printNum(num);
        incr(num);
        printNum(num);*/

        print(2);
    }
}
