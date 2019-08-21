package leetcode.linked;

import leetcode.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针法
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1.next == null) ? headB : l1.next;
            l2 = (l2.next == null) ? headA : l2.next;
        }
        return l1;
    }
}
