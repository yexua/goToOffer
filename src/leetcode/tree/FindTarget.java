package leetcode.tree;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 */
public class FindTarget {
    boolean ans = false;
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        find(root, k);
        return ans;
    }

    public void find(TreeNode root, int k) {
        if (root == null || ans) {
            return;
        }
        if (set.contains(root.val)) {
            ans = true;
        }
        set.add(k - root.val);
        findTarget(root.left, k);
        findTarget(root.right, k);
    }
}
