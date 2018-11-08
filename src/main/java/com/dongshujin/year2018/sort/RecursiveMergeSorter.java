package com.dongshujin.year2018.sort;

public class RecursiveMergeSorter {

    static int[] sort(int[] array) {
        if (null == array || 0 == array.length)
            return array;
        int[] sortedArray = new int[array.length];
        sort(array, 0, array.length-1, sortedArray);
        return sortedArray;
    }

    private static void sort(int[] array, int startIdx, int endIdx, int[] sortedArray) {
        if (startIdx >= endIdx)
            return;
        int midIdx = (startIdx + endIdx) / 2;
        sort(array, startIdx, midIdx, sortedArray);
        sort(array, midIdx + 1, endIdx, sortedArray);
        merge(array, startIdx, midIdx, endIdx, sortedArray);
    }

    static void merge(int[] array, int startIdx, int midIdx, int endIdx, int[] sortedArray) {
        int arrayFormerIdx = startIdx;
        int arrayLatterIdx = midIdx + 1;

        int index = startIdx;

        while (arrayFormerIdx <= midIdx && arrayLatterIdx <= endIdx) {
            if (array[arrayFormerIdx] < array[arrayLatterIdx]) {
                sortedArray[index++] = array[arrayFormerIdx++];
            } else {
                sortedArray[index++] = array[arrayLatterIdx++];
            }
        }

        while (arrayFormerIdx <= midIdx) {
            sortedArray[index++] = array[arrayFormerIdx++];
        }
        while (arrayLatterIdx <= endIdx) {
            sortedArray[index++] = array[arrayLatterIdx++];
        }

        for (int i = startIdx; i <= endIdx; i++) {
            array[i] = sortedArray[i];
        }

//        if (endIdx + 1 - startIdx >= 0)
//          System.arraycopy(sortedArray, startIdx, array, startIdx, endIdx + 1 - startIdx);
    }


    public static void main(String[] args) {
        int[] array = new int[]{10, 3, -1, 3, 5, 7};

        int[] sortedArray = RecursiveMergeSorter.sort(array);

        for (int num : sortedArray) {
            System.out.print(num);
            System.out.print(",");
        }
        System.out.println();
    }
}
