package leetcode.linked;

import leetcode.ListNode;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        Stack<Integer> s1 = initStack(l1);
        Stack<Integer> s2 = initStack(l2);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = dummyHead.next;
            dummyHead.next = node;
            carry = sum / 10;
        }
        return dummyHead.next;
    }

    private Stack<Integer> initStack(ListNode l) {
        Stack<Integer> s = new Stack<>();
        while (l != null) {
            s.push(l.val);
            l = l.next;
        }
        return s;
    }
}
