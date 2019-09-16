package leetcode.tree;

import leetcode.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = toBST(nums, l, mid - 1);
            root.right = toBST(nums, mid + 1, r);
            return root;
        }
        return null;
    }
}
