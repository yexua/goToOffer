package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 */
public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) {
            return leftVal;
        }
        return rightVal;
    }

    public int findSecondMinimumValue_(TreeNode root) {
        int min = root.val;
        int sMin = -1;
        sMin = preOrder(root, min, sMin);
        return sMin;
    }

    public int preOrder(TreeNode root, int min, int sMin) {
        if (root == null) {
            return sMin;
        }
        if (root.val > min && sMin == -1) {
            sMin = root.val;
        }
        if (root.val < sMin && root.val > min) {
            sMin = root.val;
        }
        sMin = preOrder(root.left, min, sMin);
        sMin = preOrder(root.right, min, sMin);

        return sMin;
    }
}
