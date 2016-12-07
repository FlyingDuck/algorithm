package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/7.
 */
public class Question41_1 {

    /*
    Q：输入一个正整数S，打印出所有和为S的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6＝7+8＝15，所以打印结果 1～5，4～6，7～8
    A：
     */

    public void findContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }

        int head = 1;
        int tail = 2;

        int mid = (sum+1)/2;

        int curSum = head+tail;

        while (head < mid) {
            if (curSum == sum) {
                System.out.println("result: " + head + " ~ " + tail);
            }
            while (curSum > sum && head < mid) {
                curSum -= head;
                head++;
                if (curSum == sum) {
                    System.out.println("result: " + head + " ~ " + tail);
                }
            }

            tail++;
            curSum += tail;
        }
    }

    public static void main(String[] args) {
        Question41_1 question41_1 = new Question41_1();

        question41_1.findContinuousSequence(15);
    }


}
