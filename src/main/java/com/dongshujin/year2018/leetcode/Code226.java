package com.dongshujin.year2018.leetcode;

import com.dongshujin.year2018.leetcode.structure.TreeNode;

public class Code226 {

    public TreeNode invertTree(TreeNode root) {
        if (null == root)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
