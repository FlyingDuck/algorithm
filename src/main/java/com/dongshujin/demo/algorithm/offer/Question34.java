package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question34 {

    /*
    丑数
    Q：我们把只包含因子2、3、5的数称为丑数。求按顺序从小到大的顺序第1500个丑数。例如6、8都是丑数。但14不是，因为它还包含因子7.习惯把1当作第一个丑数。
     */

    public int getUglyNum(int sum) {
        if (sum <= 0)
            return 0;

        int[] uglyNums = new int[sum];
        uglyNums[0] = 1;

        int nextUglyIndex = 1;
        int uglyNum2Index = 0;
        int uglyNum3Index = 0;
        int uglyNum5Index = 0;

        while (nextUglyIndex < sum) {
            int min = min(uglyNums[uglyNum2Index]*2, uglyNums[uglyNum3Index]*3, uglyNums[uglyNum5Index]*5);
            uglyNums[nextUglyIndex] = min;

            while (uglyNums[uglyNum2Index]*2 <= uglyNums[nextUglyIndex]) {
                uglyNum2Index++;
            }
            while (uglyNums[uglyNum3Index]*3 <= uglyNums[nextUglyIndex]) {
                uglyNum3Index++;
            }
            while (uglyNums[uglyNum5Index]*5 <= uglyNums[nextUglyIndex]) {
                uglyNum5Index++;
            }

            //System.out.println(uglyNum2Index +" - " + uglyNum3Index + " - " + uglyNum5Index + " | " + nextUglyIndex);

            nextUglyIndex++;
        }

        int ugly = uglyNums[nextUglyIndex-1];
        return ugly;
    }

    private int min(int num1, int num2, int num3) {
        return num1 > num2 ? (num2 > num3 ? num3 : num2) : (num1 < num3 ? num1 : num3);
    }

    public static void main(String[] args) {
        Question34 question34 = new Question34();

        int result = question34.getUglyNum(4);
        System.out.println("result: " + result);
    }
}
