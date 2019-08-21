package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点
 * 路径长度中的最大值。这条路径可能穿过根结点。
 */
public class DiameterOfBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        deep(root);
        return max;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = deep(root.left);
        int r = deep(root.right);
        max = Math.max(l + r, max);
        return Math.max(l, r) + 1;
    }

}
