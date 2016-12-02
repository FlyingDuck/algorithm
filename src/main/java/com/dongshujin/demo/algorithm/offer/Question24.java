package com.dongshujin.demo.algorithm.offer;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question24 {

    /*
    二叉搜索树的后序遍历序列
    Q：输入一个整数数组，判断该数组是不是某二叉搜索树的后续遍历结果。（假设输入的数组任意两数字互不相同）
    A：
     */

    public boolean isSquenceBST(int[] array, int start, int end) {
        if (null == array) {
            return false;
        }

        // 序列的最后一个节点是二叉树的头节点
        // 找到左子树
        int division = 0;
        for (division=start; division<end; division++) {
            if (array[division] > array[end]) { // 第一个大于头节点的为分界线
                break;
            }
        }

        // 遍历右子树
        for (int i=division; i<end; i++) {
            if (array[i] < array[end]) { // 如果右子树中有小于头节点的就不是后续序列
                return false;
            }
        }


        // 对分割点两侧进行（左右子树）处理
        boolean left = true, right = true;
        if (division > start) {
            left = isSquenceBST(array, start, division - 1);
        }

        if (division < end) {
            right = isSquenceBST(array, division, end - 1);

        }

        return left && right;
    }

    public static void main(String[] args) {
        Question24 question24 = new Question24();
        int[] array = new int[]{5,7,6,11,9,10, 8};

        boolean result = question24.isSquenceBST(array, 0, array.length-1);
        System.out.println("result: " + result);
    }

}
