package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/7.
 */
public class Question41 {

    /*
    和为s的两个数字 VS 和为s的连续正数序列
    Q：输入一个递增排序的数组和一个数字S，在数组中查找到两个数，使得它们的和正好是S。如果有多对数字和为S，输出任意一对。
    A：
     */

    public boolean findNumberWithSum(int[] array, int sum) {

        int head = 0, tail = array.length-1;

        while (head < tail) {
            if (array[head] + array[tail] < sum) {
                head++;
            } else if (array[head] + array[tail] > sum) {
                tail--;
            } else {
                System.out.println("result: " + array[head] + " " + array[tail]);
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Question41 question41 = new Question41();

        int[] array = new int[]{1,2,4,7,11,15};


        question41.findNumberWithSum(array, 15);
    }

}
