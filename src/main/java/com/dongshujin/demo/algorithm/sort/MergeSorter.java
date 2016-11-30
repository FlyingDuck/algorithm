package com.dongshujin.demo.algorithm.sort;

/**
 * Created by dongsj on 16/11/29.
 */
public class MergeSorter {

    private void sort(int[] array, int first, int last, int[] sortedArray) {
        if (first < last) {
            int mid = (first + last) / 2;
            sort(array, first, mid, sortedArray);
            sort(array, mid + 1, last, sortedArray);
            merge(array, first, mid, last, sortedArray);
        }
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

    public int[] toSort(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }

        if (2 > array.length) {
            return array;
        }

        int[] sortedArray = new int[array.length];

        sort(array, 0, array.length-1, sortedArray);

        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 9, 1, 4, 6, 0, 2, 8,10, 4, 5};
        int[] sortedArray = new MergeSorter().toSort(array);
        System.out.print("result : ");
//        for (int i=0; i<sortedArray.length; i++) {
//            System.out.print(sortedArray[i] + " ");
//        }

        for (int num : sortedArray) {
            System.out.print(num+" ");
        }
    }


}
