package com.dongshujin.demo.algorithm.offer;

import java.util.Random;

/**
 * Created by dongsj on 16/12/3.
 *
 */
public class Question29 {
    /*
    数组中出现次数超过一半的数字
    Q：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组 {1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
    A：1，借用快速排序中的 Partition() 函数；2，根据数组特点找出该数
     */

    // 用于随机选取基准值
    private Random random = new Random();


    public int partition(int[] array, int start, int end) {

        // 选取基准值
        int index = random.nextInt(end-start) + start;

        // 将基准值置于数组末尾，以便交换其他值
        swap(array, index, end);

        // 定义small指针，标示数组中小于基准值的位置，初始化在其实位置左侧
        int small = start-1;

        // 遍历数组，当遇到小于基准值的数时，将small指针右移，并且将这个数交换到small指向的位置
        for (int pos=start; pos<end; pos++) {
            if (array[pos] < array[end]) {
                small++;
                swap(array, pos, small);
            }
        }

        // 最后将基准值归位
        small++;
        swap(array, end, small);

        // 返回基准值所在位置
        return small;
    }

    private void swap(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }


    public int moreThanHalfNum(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }

        int middle = array.length >> 1;

        // 寻找第一个基准值位置
        int start = 0;
        int end = array.length-1;
        int pos = partition(array, start, end);

        while (pos != middle) {
            if (pos < middle) {
                start = pos+1;
            } else {
                end = pos-1;
            }
            if (start >= pos) break;
            pos = partition(array, start, end);
        }

        int result = array[middle];

        // 检查是否符合超过一半的约束
        if (!checkNum(array, result)) {
            return 0;
        }

        return result;
    }

    /**
     *  这种方法，充分利用了数组的特点。
     *  数组中有一个数字超过一半，说明它出现的次数比其他所有的数字出现的次数和还要多。因此我们可以考虑在遍历数组的时候保存两个值：一个是数组中的数字，一个是次数。
     *  当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。如果次数为零，我们需要保存下一个数字，并把次数设为1。
     *  由于我们要找的数字出现的次数比其他所有的数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
     */
    public int moreThanHalfNum2(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }

        int result = array[0];
        int times = 1;

        for (int i=1; i<array.length; i++) {
            if (result == array[i]) {
                times++;
            } else {
                if (times == 0) {
                    result = array[i];
                    times = 1;
                } else {
                    times--;
                }
            }
        }

        if (!checkNum(array, result)) {
            return 0;
        }

        return result;
    }

    private boolean checkNum(int[] array, int result) {

        int half = array.length >> 1;
        int times = 0;

        for (int i=0; i<array.length; i++) {
            if (array[i] == result) {
                times++;
                if (times > half) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Question29 question29 = new Question29();

        int[] array = new int[]{1,2,3,2,2,2,5,4,2};

        int result = question29.moreThanHalfNum(array);
        System.out.println("result: " + result);

        result = question29.moreThanHalfNum2(array);
        System.out.println("result: " + result);

    }

}
