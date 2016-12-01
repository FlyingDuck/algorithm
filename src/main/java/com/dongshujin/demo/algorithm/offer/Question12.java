package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/30.
 */
public class Question12 {


    /*
    打印1到最大的n位数
    Q：输入数字n，按顺序打印从1到n位十进制数，比如输入3，则打印1，2，3一直到最大的3位数999。
    A：
     */

    public void printToMaxNDigits(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        char[] bigNum = new char[n];
        for (int i=0; i<n; i++) {
            bigNum[i] = '0';
        }

        while (!increment(bigNum)) {
            printBigNum(bigNum);
        }
    }

    // N数全排列问题
    public void printToMaxNDigits2(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        char[] bigNum = new char[n];
        boolean[] marks = new boolean[n]; // 标记数组

        for (int num=0; num<10; num++) {
            // TODO: 16/11/30
        }

    }


    private boolean increment(char[] bigNum) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = bigNum.length;

        for (int i=nLength-1; i>=0; i--) {
            int nSum = bigNum[i] - '0' + nTakeOver;
            if (i == nLength-1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    bigNum[i] = (char) ('0' + nSum);
                }
            } else {
                bigNum[i] = (char) ('0'+nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private void printBigNum(char[] bigNum) {
        boolean isFill0 = true;

        for (int i=0; i<bigNum.length; i++) {
            if (isFill0 && bigNum[i] != '0') {
                isFill0 = false;
            }
            if (!isFill0) {
                System.out.print(bigNum[i]);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Question12 question12 = new Question12();

        //char[] bigNum = new char[]{'0', '0', '9', '7', '9', '9'};
        //question12.increment(bigNum);
        //question12.printBigNum(bigNum);

        question12.printToMaxNDigits(2);

    }

}
