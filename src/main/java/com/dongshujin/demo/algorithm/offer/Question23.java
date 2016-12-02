package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question23 {

    /*
    从上往下打印二叉树
    Q：从上往下打印出二叉树每个节点，同一层节点按照从左往右顺序打印。
    A：BFS
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


    public void printBinaryTree(BinaryTreeNode rootNode) {
        Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<BinaryTreeNode>();

        if (null == rootNode) {
            return;
        }
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data + " ");

            if (null != node.leftNode) {
                queue.offer(node.leftNode);
            }
            if (null != node.rightNode) {
                queue.offer(node.rightNode);
            }
        }
    }


    public static void main(String[] args) {
        Question23 question23 = new Question23();
        BinaryTreeNode tree = question23.constructTree();
        question23.printBinaryTree(tree);
    }


}
