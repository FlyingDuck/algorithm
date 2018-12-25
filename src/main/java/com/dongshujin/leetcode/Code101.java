package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.TreeNode;

public class Code101 {
    public boolean isSymmetric(TreeNode root) {
        if (null == root)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2)
            return true;
        if (null == root1 || null == root2)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}
