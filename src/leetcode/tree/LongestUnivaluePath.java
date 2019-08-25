package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class LongestUnivaluePath {
    private int path;

    {
        path = 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
//        pre(root, root.val);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? right + 1 : 0;
        path = Math.max(path, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public int pre(TreeNode root, int val) {
        if (root == null) return 0;
        int left = pre(root.left, root.val);
        int right = pre(root.right, root.val);
        path = Math.max(path, left + right);
        if (root.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}
