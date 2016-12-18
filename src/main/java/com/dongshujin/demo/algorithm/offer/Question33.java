package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question33 {
    /*
    把数组排成最小的数
    Q：输入一个正整数数组，把数组所有数字拼接起来排成一个数，打印能拼接出来的所有数字中的最小的一个。例如数组{3, 32, 321}，则打印出321323。
    A：m=321 n=32 有两种拼接方法 mn、nm  这两种拼接方法得到的字符串我们可以保证是长度是相同的，至于谁大 可以通过 mn=32132 和 nm=32321 的自然排序来判断，显然这里mn < nm ，那么我们可以规定 当mn < nm 时，m < n，基于此我们构造这样一个比较器，然后将这些数字串排序，得到一个序列
     */

    public void printMinNumber(int[] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }



    }
}
