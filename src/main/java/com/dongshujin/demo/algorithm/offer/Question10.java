package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/11/30.
 */
public class Question10 {

    /*
    二进制中1的个数
    Q：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数，例如9的二进制是1001，有2位是1，因此输入9，函数输出2。
    A：先判断二进制表示中最右边的一位是不是1，接着把输入的整数右移一位，继续判断
     */

    // 这中方式对正整数有效，负数右移（高位补1）会造成死循环
    public int numOfOne(int n) {
        if (n < 0) {
            throw new UnsupportedOperationException();
        }
        int count = 0;
        while (n != 0) {
            if ((n&1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // 为了处理负数，我们不右移数n，而是将我们的标示向左移
    public int numOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n&flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 这种方法利用了一个特性
    // 一个整数例如：12 （1100），减去1，变成 11（1011），是吧二进制数最右边的1的右部都变成1，左部保持不变，这个1变成0。
    // 当我们将 12&11 （1100 & 1011） ＝ 1000，我们发现二进制数少了一个1
    // 所以，按照这样的思路，每进行一次这样的操作表示就有一个1。
    public int numOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1)&n;
        }
        return count;
    }

    /*
    拓展：
    1，判断一个整数是不是2的整数次方？
    A：一个数是2的整数次方，那么它的二进制表示中只有一位是1，其他各位都是0。根据我们第三种方法的分析，那么这个数N 与上 N-1 结果是0，那么就是2的整数次方。

    2，输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n？
    例如：m=10 (1010); n=13 (1101) 需要改变3位。
     A：m^n=0111（异或运算会将两个数中不同表示的数标示成1），然后通过统计异或结果上的1个数来确定需要改变几位。

    3，输入两个整数m和n，计算m和n的二进制表示中有多少位相同？
    例如：m=10 (1010); n=13 (1101) 只有1位相同
    A：m&n=1000 （与运算会将两个数中相同位标示成1），然后通过统计与结果上1的个数来确定有几位相同。
    */

    public static void main(String[] args) {
        Question10 question10 = new Question10();
        int n = -11;
        int result;
        result= question10.numOfOne(n);
        System.out.println("result : " + result);

        result = question10.numOfOne2(n);
        System.out.println("result : " + result);

        result = question10.numOfOne3(n);
        System.out.println("result : " + result);

    }
}
