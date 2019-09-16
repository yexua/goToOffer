package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 注意: 树中至少有2个节点。
 */
public class GetMinimumDifference {
    private int min = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (preNode != null) {
            min = Math.min(min, root.val - preNode.val);
        }
        preNode = root;
        inOrder(root.right);
    }
}
