package leetcode.linked;

import leetcode.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        SwapPairs s = new SwapPairs();
        s.swapPairs(l1);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur.next != null && cur != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            pre.next = temp;
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public ListNode swapPairs_rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs_rec(next.next);
        next.next = head;
        return next;
    }
}
