package com.dongshujin.year2018.sort;

public class MergeSorter {

    static int[] sort(int[] array) {
        if (null == array || 0 == array.length)
            return array;
        int[] sortedArray = new int[array.length];

        int step = 1;

        while (step < array.length) {
            int start1 = 0;
            int start2 = start1+step;
            while (start2 < array.length) {
                int first = start1;
                int mid = start1+step-1;
                int last = start2+step-1;

                if (last >= array.length)
                    last = array.length-1;
                merge(array, first, mid, last, sortedArray);

                start1 += 2*step;
                start2 += 2*step;
            }
            step = 2*step;
        }


        return sortedArray;
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

    }


}
