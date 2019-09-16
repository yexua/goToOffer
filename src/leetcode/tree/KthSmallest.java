package leetcode.tree;

import leetcode.TreeNode;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class KthSmallest {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t6;
        KthSmallest k = new KthSmallest();
        System.out.println(k.kthSmallest_Linked(t1, 3));
        System.out.println("kkk");
    }

    public int kthSmallest_Linked(TreeNode root, int k) {
        TreeNode linkedRoot = convert(root);
        while (linkedRoot != null) {
            cnt++;
            if (cnt == k) {
                return linkedRoot.val;
            }
            linkedRoot = linkedRoot.right;
        }
        return 0;
    }

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
        if (cnt == k) {
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
    private int findChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findChild(root.left) + findChild(root.right) + 1;
    }


    private TreeNode preNode = null;

    /**
     * 将BST转化为双向链表
     *
     * @param root
     * @return
     */
    private TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertNode(root);
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        preNode = null;
        return head;
    }

    private void convertNode(TreeNode node) {
        // 遍历左子树
        if (node.left != null) {
            convertNode(node.left);
        }
        node.left = preNode;
        if (preNode != null) {
            preNode.right = node;
        }
        preNode = node;
        // 遍历右子树
        if (node.right != null) {
            convertNode(node.right);
        }
    }
}
