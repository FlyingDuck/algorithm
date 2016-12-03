package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.heap.MaxHead;
import com.dongshujin.demo.algorithm.utils.PrintUtils;

import java.util.Random;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question30 {

    /*
    最小的 K 个数
    Q：输入n个整数，找出其中最小的K个数。例如输入 4、5、1、6、2、7、8 最小的4个数是1、2、3、4。
    A：1，利用 Partition()，这种方法会修改输入数组
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
        for (int pos=start; pos<end; pos++) { // 注意这里的起始值
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

    public int[] getLeastNums(int[] array, int k) {
        if (null == array) {
            throw new IllegalArgumentException();
        }
        if (k >= array.length) {
            return array;
        }

        int start = 0;
        int end = array.length-1;

        int pos = partition(array, start, end);

        while (pos != k-1) {
            if (pos < k-1) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
            if (start >= pos) break;
            pos = partition(array, start, end);
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = array[i];
        }
        return result;
    }


    /**
     * 为了不修改输入数组，所以需要需要额外的空间，这里我们用最大堆可以有效的利用空间
     * 基于堆的 O(Nlogk)
     */
    public void getLeastNums2(int[] array, int k) {
        MaxHead maxHead = new MaxHead(k);
        for (int i=0; i<k; i++) {
            maxHead.add(array[i]);
        }

        for (int j=k; j<array.length; j++) {
            Integer top = maxHead.max();
            if (null != top && top > array[j]) {
                maxHead.popAdd(array[j]);
            }
        }

        maxHead.printHeap();
    }


    public static void main(String[] args) {
        Question30 question30 = new Question30();

        int[] array = new int[]{4, 5, 6, 1, 1, 7, 4, 8};

        //int[] result = question30.getLeastNums(array, 4);
        //PrintUtils.printArray(result);

        question30.getLeastNums2(array, 4);
    }



}
