package com.dongshujin.leetcode;

import com.dongshujin.leetcode.structure.TreeNode;

public class Code572 {

    // It is wrong. WHY?
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s && null == t)
            return true;
        if (null == s)
            return false;
        if (null == t)
            return false;

        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }


    public boolean isSubtree2(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }

    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
}
