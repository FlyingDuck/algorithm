package com.dongshujin.year2018.sort;

public class QuickSorter {

    static void sort(int[] array) {
        if (null == array || 0 == array.length)
            return;
        sort(array, 0, array.length-1);

    }

    static void sort(int[] array, int startIdx, int endIdx) {
        if (startIdx == endIdx)
            return;

        int middleIdx = partition(array, startIdx, endIdx);
        if (middleIdx > startIdx)
            sort(array, startIdx, middleIdx-1);
        if (middleIdx < endIdx)
            sort(array, middleIdx+1, endIdx);
    }

    private static int partition(int[] array, int startIdx, int endIdx) {
        int flag = array[endIdx]; // 选最后一个点为基准点

        int small = startIdx-1; // small 指针
        for (int index = startIdx; index < endIdx; index++) {
            if (array[index] < flag) {
                small++;
                swap(array, small, index);
            }
        }
        small++;
        swap(array, small, endIdx);
        return small;
    }

    private static void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, -7, 5, 6, 3, 2, 10};
        QuickSorter.sort(array);

        for (int num : array) {
            System.out.print(num);
            System.out.print(",");
        }
        System.out.println();
    }

}
