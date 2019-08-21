package leetcode.linked;

import leetcode.ListNode;

/**
 * 反转一个单链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
