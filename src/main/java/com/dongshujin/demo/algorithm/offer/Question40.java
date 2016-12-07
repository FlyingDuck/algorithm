package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/7.
 */
public class Question40 {

    /*
    Q：一个整数数组里除了两个数字之外，其他的数字都出现了两次。填写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    A：

    考虑 如果只有一个数字出现了一次，其他数字都出现了两次，那么将所有的数字做抑或运算，最后的结果便是那个只出现了一次的数字。
     */

    public void findNumsAppearOnce(int[] array) {
        if (null == array || array.length < 2) {
            return;
        }

        int resultExclusiveOR = 0;
        for (int data : array) {
            resultExclusiveOR ^= data;
        }

        int indexOf1 = findFirstBitIs1(resultExclusiveOR);

        int num1 = 0, num2 = 0;
        for (int data : array) {
            if (isBit1(data, indexOf1)) {
                num1 ^= data;
            } else {
                num2 ^= data;
            }
        }

        System.out.println("num is : " + num1 + " " + num2);
    }

    private int findFirstBitIs1(int num) {
        int index = 0;
        while ((num&1) == 0 && (index < 8*4)) {
            num = num>>1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int num, int indexOf1) {
        num = num>>indexOf1;
        return (num&1)==1;
    }


    public static void main(String[] args) {
        Question40 question40 = new Question40();

//        int num = 10;
//        System.out.println("num: " + num);
//
//        question40.isBit1(num, 1);
//        System.out.println("num: " + num);
        int[] array = new int[]{2,4,3,6,3,2,5,5};

        question40.findNumsAppearOnce(array);


    }



}
