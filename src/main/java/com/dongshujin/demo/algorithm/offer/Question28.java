package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question28 {

    /*
    字符串排列
    Q：输入一个字符串，打印出该字符串中字符的所有排列。例如 输入abc,则打印 abc、bac、bca、cab、cba
    A：
     */

    public void permutation(String str) {
        char[] chars = str.toCharArray();
        char[] result = new char[chars.length];
        boolean[] marks = new boolean[chars.length];

        permutation(chars, result, marks, 0);
    }

    private void permutation(char[] chars, char[] result, boolean[] marks, int pos) {

        if (pos == result.length) {
            for (char ch : result) {
                System.out.print(" " + ch);
            }
            System.out.println();
            return;
        }

        for (int i=0; i<chars.length; i++) {
            // 如果当前字符已经被标记（被选取过）则继续选取下一个字符
            if (marks[i]) {
                continue;
            }

            // 将当前字符放入当前位置
            result[pos] = chars[i];
            marks[i] = true;

            // 继续进行下一个位置的排列
            permutation(chars, result, marks, pos+1);

            // 尝试结束后 取回当前放入的字符
            marks[i] = false;
        }
    }


    public static void main(String[] args) {
        Question28 question28 = new Question28();

        question28.permutation("abc");

    }

    /*
    Q：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放在正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
    A：先进行全排，然后再进行判断
     */

    /*
    Q：在8*8的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后不得处在同一行、同一列、同一对角线上。总共有多少种符合条件的摆法。
    A：
     */


}
