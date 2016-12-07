package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

/**
 * Created by dongsj on 16/12/7.
 */
public class Question39_1 {

    /*
    Q：输入一颗二叉树的根节点，判断该树是不是平衡二叉树，如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一颗平衡二叉树。
    A：
     */

    private int treeDepth(BinaryTreeNode rootNode) {
        if (null == rootNode) {
            return 0;
        }

        int left = treeDepth(rootNode.leftNode);
        int right = treeDepth(rootNode.rightNode);

        return (left > right) ? (left+1) : (right+1);
    }

    public boolean isBalanced(BinaryTreeNode rootNode) {
        if (null == rootNode) {
            return true;
        }

        int left = treeDepth(rootNode.leftNode);
        int right = treeDepth(rootNode.rightNode);
        int diff = right - left;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(rootNode.leftNode) && isBalanced(rootNode.rightNode);
    }

    public boolean isBalanced(BinaryTreeNode rootNode, int depth) {
        // TODO: 16/12/7
        if (rootNode == null) {
            depth = 0;
            return true;
        }

        int left =0 , right = 0;
        if (isBalanced(rootNode.leftNode, left) && isBalanced(rootNode.rightNode, right)) {
            int diff = left-right;
            if (diff<=1 && diff>=-1) {
                depth = 1 + (left>right ? left : right);
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(5, node1, null);

        BinaryTreeNode node3 = new BinaryTreeNode(4, node2,null);
        BinaryTreeNode node4 = new BinaryTreeNode(2, node3, null);

        BinaryTreeNode node5 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(3, null, node5);

        BinaryTreeNode rootNode = new BinaryTreeNode(1, node4, node6);

        Question39_1 question39_1 = new Question39_1();

        boolean result = question39_1.isBalanced(rootNode);
        System.out.println("result: " + result);


        int depth = 0;
        result = question39_1.isBalanced(rootNode, depth);
        System.out.println("result: " + result);

    }


}
