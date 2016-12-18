package com.dongshujin.demo.algorithm.sort;

import com.dongshujin.demo.algorithm.utils.PrintUtils;

/**
 * Created by dongsj on 16/11/29.
 *
 * 非递归归并排序
 */
public class MergeSorter2 {

    private int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int[] sortedArray = new int[array.length];

        int step = 1;

        while (step < array.length) {
            System.out.println("step: " + step);
            int start1 = 0, start2 = start1+step;
            while (start2 < array.length) {
                int first = start1, mid = start1+step-1, last = start2+step-1;
                if (last >= array.length) last = array.length-1;
                merge(array, first, mid, last, sortedArray);

                start1 += 2*step;
                start2 += 2*step;
            }
            step = 2*step;
        }

        return sortedArray;
    }


    private void merge(int[] array, int first, int mid, int last, int[] sortedArray) {

        int arrp1 = first, arrp2 = mid+1;
        int index= first;

        while (arrp1 <= mid && arrp2 <=last) {
            if (array[arrp1] < array[arrp2]) {
                sortedArray[index++] = array[arrp1++];
            } else {
                sortedArray[index++] = array[arrp2++];
            }
        }

        while (arrp1 <= mid) {
            sortedArray[index++] = array[arrp1++];
        }
        while (arrp2 <= last) {
            sortedArray[index++] = array[arrp2++];
        }

        for (int i=first; i<=last; i++) { // 复制回去
            array[i] = sortedArray[i];
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{7, 9, 1, 4, 6, 0, 2, 8,10, 4, 5};
        int[] array2 = new int[]{1,1,1,1};
        int[] array3 = new int[]{1,1,1,1, 0, 0, 0};
        int[] array4 = new int[]{7};
        int[] sortedArray = new MergeSorter2().sort(array4);
        System.out.print("result : ");

        PrintUtils.printArray(sortedArray);
    }

}
