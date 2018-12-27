package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.TreeNode;

public class Code104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode root, int currentDepth) {
        if (null == root)
            return currentDepth;
        return Math.max(maxDepth(root.left, currentDepth), maxDepth(root.right, currentDepth)) + 1;
    }
}
