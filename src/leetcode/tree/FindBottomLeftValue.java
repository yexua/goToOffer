package leetcode.tree;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 */
public class FindBottomLeftValue {

    int res;
    int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        bottomLeft(root, 1);
        return res;
    }

    public void bottomLeft(TreeNode root, int depth) {
        if (root == null)
            return;

        bottomLeft(root.left, depth + 1);

        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        }

        bottomLeft(root.right, depth + 1);
    }


    public int findBottomLeftValue_(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }
}
