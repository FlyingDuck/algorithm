package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

/**
 * Created by dongsj on 16/12/6.
 */
public class Question39 {
    /*
    二叉树的深度
    Q：输入一颗二叉树的根节点，求该树的深度。从根节点到叶子节点依次经过的节点（含根、叶子节点）形成树的一条路径，最长路径长度为树的深度。
    A：
     */
    public int treeDepth(BinaryTreeNode rootNode) {
        if (null == rootNode) {
            return 0;
        }

        int left = treeDepth(rootNode.leftNode);
        int right = treeDepth(rootNode.rightNode);

        return (left > right) ? (left+1) : (right+1);
    }


    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(5, node1, null);

        BinaryTreeNode node3 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(2, node3, node2);

        BinaryTreeNode node5 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(3, null, node5);

        BinaryTreeNode rootNode = new BinaryTreeNode(1, node4, node6);


        Question39 question39 = new Question39();

        int result = question39.treeDepth(rootNode);
        System.out.println("result :" + result);
    }

}
