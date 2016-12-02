package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question19 {

    /*
    二叉树镜像
    Q：完成函数，输入一个二叉树，该函数输出它的镜像。
    A：
     */
    private BinaryTreeNode constructTree() {
        BinaryTreeNode node1 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(11, null, null);

        BinaryTreeNode node5 = new BinaryTreeNode(6, node1, node2);
        BinaryTreeNode node6 = new BinaryTreeNode(10, node3, node4);

        BinaryTreeNode rootNode = new BinaryTreeNode(8, node5, node6);
        return rootNode;
    }


    public void mirrorTree(BinaryTreeNode tree) {
        if (null == tree || (null == tree.leftNode && null == tree.rightNode)) {
            return;
        }

        BinaryTreeNode tmpNode = tree.leftNode;
        tree.leftNode = tree.rightNode;
        tree.rightNode = tmpNode;

        if (null != tree.leftNode) {
            mirrorTree(tree.leftNode);
        }

        if (null != tree.rightNode) {
            mirrorTree(tree.rightNode);
        }
    }



    public static void main(String[] args) {
        Question19 question19 = new Question19();

        BinaryTreeNode tree = question19.constructTree();
        question19.mirrorTree(tree);

    }

}
