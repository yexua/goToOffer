package leetcode.tree;

import leetcode.ListNode;
import leetcode.TreeNode;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode preNode = preMid(head);
        ListNode mid = preNode.next;
        // 断开链表
        preNode.next = null;
        TreeNode t = new TreeNode(mid.val);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    /**
     * 找到链表中间结点的前置结点
     *
     * @param head
     * @return
     */
    private ListNode preMid(ListNode head) {
        ListNode pre = head, s = head, f = head.next;
        while (f != null && f.next != null) {
            pre = s;
            s = s.next;
            f = f.next.next;
        }
        return pre;
    }
}
