package com.dongshujin.year2018.offer;

/**
 * 面试题3：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的递增的顺序排序。请完成一个函数，输入这样一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Q3 {

    private static boolean exist(int[][] array, final int target) {
        if (null == array) {
            throw new IllegalArgumentException("array cannot be null");
        }

        int column = array.length;
        int rows = array[0].length;

        if (column == 0 && rows == 0) {
            return false;
        }


        int cIndex = column - 1;
        int rIndex = 0;

        while (cIndex >= 0) {
            if (array[rIndex][cIndex] > target) {
                cIndex--;
            } else if (array[rIndex][cIndex] == target) {
                return true;
            } else {
                break;
            }
        }

        if (cIndex == -1)
            return false;

        while (rIndex < rows) {
            if (array[rIndex][cIndex] < target) {
                rIndex++;
            } else if (array[rIndex][cIndex] == target) {
                return true;
            } else {
                return false;
            }
        }

        if (rIndex == rows)
            return false;

        return false;
    }

    private static boolean exist2(int[][] array, final int target) {
        if (null == array) {
            throw new IllegalArgumentException("array cannot be null");
        }

        int column = array.length;
        int rows = array[0].length;

        if (column == 0 && rows == 0) {
            return false;
        }



        int cIndex = column - 1;
        int rIndex = 0;

        while (cIndex >= 0 && rIndex < rows) {
            if (array[cIndex][rIndex] > target) {
                cIndex--;
            } else if (array[cIndex][rIndex] < target) {
                rIndex++;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        int target = 14;

        boolean result = Q3.exist(array, target);
        System.out.println("result = " + result);

        boolean result2 = Q3.exist2(array, target);
        System.out.println("result2 = " + result2);


    }

}
