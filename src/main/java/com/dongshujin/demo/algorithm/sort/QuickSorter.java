package com.dongshujin.demo.algorithm.sort;


import com.dongshujin.demo.algorithm.utils.PrintUtils;

import java.util.Random;

/**
 * Created by dongsj on 16/11/30.
 *
 * 快速排序
 *
 * 关键点：选取基准值，将大于基准值的移动到一边，小于基准值的移动到另一边
 *
 * 要点：
 *
 */
public class QuickSorter {
    private Random random = new Random();


    public void execute(int[] array) {
        sort(array, 0, array.length-1);
    }

    private void sort(int[] array,int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition(array, start, end);
        if (index > start) {
            sort(array, start, index-1);
        }
        if (index < end) {
            sort(array, index+1, end);
        }
    }

    /**
     * 选取基准值，并确定基准值的位置，
     * 该函数可以用于寻找数组中最小的（最大的）第K个数，
     * @param array
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] array, int start, int end) {
        if (null == array || array.length ==0 || start<0 || end >= array.length) {
            throw new IllegalArgumentException();
        }

        int index = random.nextInt(end-start) + start; // start - end 之间的随机数
        swap(array, index, end); // 将选取的基准值暂存在数组末尾

        int small = start-1; // small指针指向 当前小于基准值的最新（最右侧）一个元素，初始化在数组头部之前
        for (index = start; index<end; index++) {
            if (array[index] < array[end]) { // 当找到比基准值小的数时， 将其交换到数组左部
                small++;
                swap(array, index, small);
            }
        }
        // 最后将基准值归位到两部分中间
        small++;
        swap(array, small, end);
        return small;
    }

    private void swap(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 2, 1, 7, 9, 0, 3, -1};

        QuickSorter sorter = new QuickSorter();
        sorter.execute(array);

        PrintUtils.printArray(array);

    }
}
