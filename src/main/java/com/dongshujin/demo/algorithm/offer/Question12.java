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

    public void printToMaxNDigits3(int n) {
        if (n<=0) {
            throw new IllegalArgumentException();
        }

        char[] bigNum = new char[n];
        for (int i=0; i<n; i++) {
            bigNum[i] = '0';
        }

        for (int i=0; i<10; i++) {
            bigNum[0] = (char) ('0'+i);
            printToMaxOfNDigitsRecursively(bigNum, 0);
        }
    }

    private void printToMaxOfNDigitsRecursively(char[] bigNum, int index) {
        if (index == bigNum.length-1) {
            printBigNum(bigNum);
            return;
        }

        for (int i=0; i<10; i++) {
            bigNum[index+1] = (char) ('0'+i);
            printToMaxOfNDigitsRecursively(bigNum, index+1);
        }
    }



    private boolean increment(char[] bigNum) {
        boolean isOverFlow = false;
        int nTakeOver = 0;
        int nLength = bigNum.length;

        for (int i=nLength-1; i>=0; i--) {
            int nSum = bigNum[i] - '0' + nTakeOver;
            if (i == nLength-1) { // 是个位的话 就需要再各位上执行加1运算
                nSum++;
            }
            if (nSum >= 10) { // 判断需要进位
                if (i == 0) { // 已经是最高位，则表示为溢出
                    isOverFlow = true;
                } else { // 不是最高位，
                    nSum -= 10; // 将sum置0
                    nTakeOver = 1; // 进1
                    bigNum[i] = (char) ('0' + nSum); // 当前位设置成0
                }
            } else { // 不需要进位 则自增结束，跳出循环
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

       // question12.printToMaxNDigits(2);

        question12.printToMaxNDigits3(2);

    }

}
