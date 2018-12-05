package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code538 {

    public TreeNode convertBST1(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in the left subtree. */
            node = node.left;
        }

        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        middleTraverse(list, root);

        for (int i=1; i<list.size(); i++) {
            TreeNode node = list.get(i);
            node.val += list.get(i-1).val;
        }
        return root;
    }

    private void middleTraverse(List<TreeNode> list, TreeNode root) {
        if (root == null)
            return;
        middleTraverse(list, root.right);
        list.add(root);
        middleTraverse(list, root.left);
    }

}
