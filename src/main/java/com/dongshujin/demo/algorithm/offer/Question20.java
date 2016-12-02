package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question20 {

    /*
    顺时针打印矩阵
    Q：输入一个矩阵，按照从外到里顺时针的顺序依次打印出每一个数字
    1   2   3   4   5
    6   7   8   9   10
    11  12  13  14  15
    16  17  18  19  20
    21  22  23  24  25
    26  27  28  29  30
     */

    public void printMatrix(int[][] array) {
        if (null == array) {
            throw new IllegalArgumentException();
        }

        int startX=0, endX=array.length-1;
        int startY=0, endY=array[0].length-1;

        int[][] directions = new int[][]{
                {0, 1},     // 向右
                {1, 0},     // 向下
                {0, -1},    // 向左
                {-1, 0}     // 向上
        };

        int derection = 0;
        int x=0, y=0;
        while (startX <= endX && startY <= endY) { // 边界收到一个点时结束循环
            // 朝当前方向移动
            while ((x >= startX && x <= endX) && (y >= startY && y <= endY)) { // 判断是否越界
                System.out.print(array[x][y]+" ");

                x += directions[derection][0];
                y += directions[derection][1];
            }

            // 越界，回退到上一步
            x -= directions[derection][0];
            y -= directions[derection][1];

            // 更新边界
            if (derection == 0) {
                startX++;
                x = startX;
            } else if (derection == 1) {
                endY--;
                y = endY;
            } else if (derection ==2) {
                endX--;
                x = endX;
            } else if (derection == 3) {
                startY++;
                y = startY;
            }

            // 调整方向
            derection = (derection+1)%directions.length;
        }

    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        Question20 question20 = new Question20();

        question20.printMatrix(array);
    }


}
