package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/3.
 */
public class Question32 {

    /*
    从1到n整数中1出现的次数
    Q：输入一个整数n，求从1到n这n个整数中十进制表示中1出现的次数。输入12，从1到12这些整数中包含1的数字有1、10、11、12，1总共出现了5次。
     */

    public int numberOfOne(char[] number) {
        int first = number[0] - '0';

        if (number.length == 1) {
            if (first == 0)
                return 0;
            else if (first > 0)
                return 1;
        }

        // TODO: 16/12/3


        return 0;
    }

}
