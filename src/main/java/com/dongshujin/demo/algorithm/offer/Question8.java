package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/30.
 *
 *
 *
 */
public class Question8 {
   /*
    旋转数组的最小数字
    Q：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
    A: 使用二分的方法，每次将查找范围缩小到原来的一半。
     */

   public int min(int[] array) {
       if (null == array) {
           throw new IllegalArgumentException();
       }

       int start = 0;
       int end = array.length-1;
       int mid = start;


       while (array[start] >= array[end]) {
           if (end-start==1) {
               mid = end;
               break;
           }

           mid = (start+end)/2;

           if (array[mid] > array[end]) {
               start = mid;
           } else if (array[mid] < array[end]) {
               end = mid;
           } else {
               return minInOrder(array, start, end);
           }
       }
       return array[mid];
   }

   private int minInOrder(int[] array, int start, int end) {
       int result = array[start];
       for (int num : array) {
           if (num < result) {
               result = num;
           }
       }
       return result;
   }

   public static void main(String[] args) {
       int[] array1 = new int[]{3,4,5,1,2};
       int[] array2 = new int[]{1,1,1,1,0,1,1};

       Question8 question8 = new Question8();

       System.out.println("result: " + question8.min(array1));
       System.out.println("result: " + question8.min(array2));
   }

}
