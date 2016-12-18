package com.dongshujin.demo.algorithm.offer;

import com.dongshujin.demo.algorithm.offer.tree.BinaryTreeNode;

/**
 * Created by dongsj on 16/12/2.
 */
public class Question18 {

    /*
    Q：输入两颗二叉树A和B，判断B是不是A的子结构。
    A：
     */
    private BinaryTreeNode constructA() {
        BinaryTreeNode node1 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(7, null, null);

        BinaryTreeNode node3 = new BinaryTreeNode(2, node1, node2);
        BinaryTreeNode node4 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(8, node4, node3);

        BinaryTreeNode node6 = new BinaryTreeNode(7, null, null);

        BinaryTreeNode rootNode = new BinaryTreeNode(8, node5, node6);

        return rootNode;
    }

    private BinaryTreeNode constructB() {
        BinaryTreeNode node1 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node3 = new BinaryTreeNode(2, node2, null);

        BinaryTreeNode rootNode = new BinaryTreeNode(8, node1,node3);

        return rootNode;
    }

    public boolean isSubTree(BinaryTreeNode treeA, BinaryTreeNode treeB) {
        if (null == treeA || null == treeB) {
            return false;
        }

        boolean hasTree = false;
        if (treeA.data == treeB.data) {
            // 判断左右子树是否相同, 这里树B也可能有多层结构，所以依然要使用递归去判断两棵树是否相同
            hasTree = isTree1HasTree2(treeA, treeB);
        }
        if (!hasTree) { // 没有找到，则继续向左右子树遍历
            hasTree = isSubTree(treeA.leftNode, treeB);
        }
        if (!hasTree) {
            hasTree = isSubTree(treeA.rightNode, treeB);
        }

        return hasTree;
    }

    private boolean isTree1HasTree2(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        if (null == tree2) {
            return true;
        }
        if (null == tree1) {
            return false;
        }

        // 先判断 父节点是否相同
        // 递归判断左右子树 是否相同
        if (tree1.data != tree2.data) {
            return false;
        }
        return isTree1HasTree2(tree1.leftNode, tree2.leftNode) && isTree1HasTree2(tree1.rightNode, tree2.rightNode);
    }


    public static void main(String[] args) {
        Question18 question18 = new Question18();

        BinaryTreeNode treeA = question18.constructA();
        BinaryTreeNode treeB = question18.constructB();

        boolean result = question18.isSubTree(treeA, treeB);
        System.out.println("result : " + result);
    }

}
