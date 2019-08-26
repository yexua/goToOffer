package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class ConvertBST {
    private int sum = 0;

    /**
     * 搜索树的中序遍历就是从小到大，反过来就是从大到小， 然后做累加
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        traver(root);
        return null;
    }

    private void traver(TreeNode node) {
        if(node != null){
            traver(node.right);
            sum += node.val;
            node.val = sum;
            traver(node.left);
        }
    }
}
