package com.dongshujin.year2018.offer;

/**
 * 面试题8：旋转数组的最小值
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class Q8 {

    static int min(int[] array) {
        if (null == array || 0 == array.length) {
            throw new IllegalArgumentException(); // IAE
        }
        if (1 == array.length)
            return array[0];
        int headIdx = 0;
        int tailIdx = array.length-1;
        int middleIndex = (headIdx+tailIdx)/2;

        while (middleIndex != headIdx && middleIndex != tailIdx) {
            if (array[middleIndex] > array[tailIdx]) {
                headIdx = middleIndex;
            } else if (array[middleIndex] < array[tailIdx]) {
                tailIdx = middleIndex;
            } else if (array[middleIndex] == array[tailIdx] && array[middleIndex] != array[headIdx]) {
                tailIdx = middleIndex;
            } else if (array[middleIndex] == array[headIdx] && array[middleIndex] != array[tailIdx]) {
                headIdx = middleIndex;
            } else {
                return minInOrder(array);
            }

            middleIndex = (headIdx + tailIdx)/2;
        }

        return array[headIdx] < array[tailIdx] ? array[headIdx] : array[tailIdx];
    }

    private static int minInOrder(int[] array) {
        int result = array[0];
        for (int i=0; i<array.length; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 5, 1, 2};
        int result = Q8.min(array);
        System.out.println("result = " + result);


        int[] array1 = new int[]{3, 3, 3, 3, 1};
        int result1 = Q8.min(array1);
        System.out.println("result = " + result1);

        int[] array2 = new int[]{3, 1, 2, 2, 2, 2, 2};
        int result2 = Q8.min(array2);
        System.out.println("result = " + result2);

        int[] array3 = new int[]{2, 1, 2, 2, 2, 2, 2};
        int result3 = Q8.min(array3);
        System.out.println("result = " + result3);


        int[] array4 = new int[]{1, 2, 3, 3, 4, 5};
        int result4 = Q8.min(array4);
        System.out.println("result = " + result4);

        int[] array5 = new int[]{5, 4, 3, 2, 0};
        int result5 = Q8.min(array5);
        System.out.println("result = " + result5);
    }

}

