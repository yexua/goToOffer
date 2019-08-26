package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 */
public class KthSmallest {

    private int res, cnt = 0;

    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_in(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        cnt++;
        if(cnt == k){
            res = node.val;
            return;
        }
        inOrder(node.right, k);
    }

    /**
     * 查找左子树节点个数为leftN,如果K<=leftN,则所查找节点在左子树上.
     * 若K=leftN+1,则所查找节点为根节点
     * 若K>leftN+1,则所查找节点在右子树上,按照同样方法查找右子树第K-leftN个节点
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int leftN = findChild(root.left);
        if (leftN + 1 == k) {
            return root.val;
        } else if (k <= leftN) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftN - 1);
        }
    }

    /**
     * 查找子节点个数
     *
     * @param root
     * @return
     */
    public int findChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findChild(root.left) + findChild(root.right) + 1;
    }
}
