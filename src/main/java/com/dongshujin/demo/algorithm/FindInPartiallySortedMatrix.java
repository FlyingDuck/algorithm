package com.dongshujin.demo.algorithm;

/**
 * Created by dongsj on 16/11/28.
 *
 * 在一个二维数组中，每行都是按照从左往右递增的顺序排序，每列也是都是按照从上到下递增的顺序排序的。现从这样一个数组中查找一个整数。
 *
 */
public class FindInPartiallySortedMatrix {

    public boolean find(int[][] array, int target) {
        boolean found = false;

        if (null != array) {
            int totalRow = array.length;
            int totalColumns = array[0].length;

            int row = 0;
            int columns = totalColumns-1;

            while (row < totalColumns && columns >= 0) {
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


}
