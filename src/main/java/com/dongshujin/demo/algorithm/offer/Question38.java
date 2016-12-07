package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/6.
 */
public class Question38 {

    /*
    数字在排序数组中出现的次数
    Q：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5} 和数字 3，由于3在这个数组中出现了4次，因此输出4。
    A：
    1，一种思路，考虑是排序数组，利用二分查找，先找到一个出现的数字，然后从这个数字向两边扩展，就可以找到所有出现的数；
    2，通过二分查找，找到第一个数字K和最后一个数字K
     */

    public int getNumOfK(int[] array, int k) {
        int num = 0;
        if (null == array) {
            return num;
        }

        int first = getFirstK(array, 0, array.length-1, k);
        int last = getLastK(array, 0, array.length-1, k);
        if (first>-1 && last>-1) {
            num = last-first+1;
        }
        return num;
    }

    private int getFirstK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
        if (array[mid] > k) {
            end = mid-1;
        } else if (array[mid] < k) {
            start = mid+1;
        } else {
            if ((mid > 0 && array[mid-1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid-1;
            }
        }

        return getFirstK(array, start, end, k);
    }

    private int getLastK(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int mid = (start+end)/2;
        if (array[mid] > k) {
            end = mid-1;
        } else if (array[mid] < k) {
            start = mid+1;
        } else {
            if ((mid < array.length-1 && array[mid+1] != k) || mid == array.length-1) {
                return mid;
            } else {
                start = mid+1;
            }
        }
        return getLastK(array, start, end, k);
    }


    public static void main(String[] args) {
        Question38 question38 = new Question38();

        int[] array = new int[]{1,2,3,3,3,3,4,5};

        int result = question38.getNumOfK(array, 3);
        System.out.println("result: " + result);
    }


}
