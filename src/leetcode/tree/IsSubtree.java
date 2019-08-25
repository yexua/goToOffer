package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
 */
public class IsSubtree {

    TreeNode it;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        it = t;
        return func(s,t);
    }

    public boolean func(TreeNode s, TreeNode t){//判断是否为相同的树
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        return s.val == t.val ?
                func(s.left,t.left) && func(s.right,t.right)  ||
                        func(s.left,t) || func(s.right,t)
                : func(s.left,it) || func(s.right,it);
    }


    public boolean isSubtree_(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        // 这两个树相等 || 这个树是左树的子树 || 这个树是右树的子树
        return isSubtreeWithRoot(s, t) && isSubtree_(s.left, t.left) && isSubtree_(s.right, s.right);
    }

    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}
