package com.dongshujin.demo.algorithm.offer.tree;

/**
 * Created by dongsj on 16/12/2.
 */
public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    public BinaryTreeNode(){}

    public BinaryTreeNode(int data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
