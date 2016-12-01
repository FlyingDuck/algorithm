package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/28.
 *
 *
 *
 */
public class Question3 {

    /*
    Q：在一个二维数组中，每行都是按照从左往右递增的顺序排序，每列也是都是按照从上到下递增的顺序排序的。现从这样一个数组中查找一个整数。
    A：
     */

    public boolean find(int[][] array, int target) {
        boolean found = false;

        if (null != array) {
            int totalRows = array.length;
            int totalColumns = array[0].length;

            int row = 0;
            int columns = totalColumns-1;

            while (row < totalRows && columns >= 0) {
                if (array[row][columns] < target) {
                    row++;
                } else if (array[row][columns] > target) {
                    columns--;
                } else {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }


    public static void main(String[] args) {
        Question3 question3 = new Question3();
        int[][] array = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean result = question3.find(array, 7);
        System.out.println("result: " + result);
    }


}
