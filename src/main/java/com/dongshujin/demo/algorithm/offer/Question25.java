package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

import java.util.List;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question25 {

    /*
    二叉树中和为某一值的路径
    Q：输入一颗二叉树和一个整数，打印出二叉树中节点值和为输入整数的所有路径。从根节点开始往下一直到叶节点
     */

    private BinaryTreeNode constructTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(5, node1, node2);

        BinaryTreeNode node4 = new BinaryTreeNode(12, null, null);

        BinaryTreeNode rootNode = new BinaryTreeNode(10, node3, node4);

        return rootNode;
    }

    public void findPath(BinaryTreeNode node, BinaryTreeNode[] resultArray, int resultIndex, int currentSum, int targetSum) {
        currentSum += node.data;
        resultArray[resultIndex++] = node;

        // 如果到达叶子节点 判断值是否相等，相等则输出
        if (null == node.leftNode && null == node.rightNode) {
            if (currentSum == targetSum) {
                // 打印路径
                for (int i=0; i<resultIndex; i++) {
                    System.out.print(" " + resultArray[i].data);
                }
                System.out.println();
            }
        }

        // 不是叶子节点
        // 1, 已经大于目标值 则不继续遍历, 回退到前一个状态
        // 2, 没有大于目标值 则继续遍历
        if (currentSum < targetSum) {
            if (null != node.leftNode) {
                findPath(node.leftNode, resultArray, resultIndex, currentSum, targetSum);
            }
            if (null != node.rightNode) {
                findPath(node.rightNode, resultArray, resultIndex, currentSum, targetSum);
            }
        }

        currentSum -= node.data;
        resultIndex--;
    }


    public static void main(String[] args) {
        Question25 question25 = new Question25();

        BinaryTreeNode tree = question25.constructTree();

        BinaryTreeNode[] resultArray = new BinaryTreeNode[10];

        question25.findPath(tree, resultArray, 0, 0, 22);
    }


}
