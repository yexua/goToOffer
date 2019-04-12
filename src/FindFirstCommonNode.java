/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);ListNode p2 = new ListNode(8);
        ListNode p3 = new ListNode(5);ListNode p4 = new ListNode(6);
        ListNode p5 = new ListNode(7);
        p1.next = p2;p2.next = p3;p3.next = p4; p4.next = p5;

        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(3);
        c1.next = c2; c2.next = c3;
        ListNode a1 = new ListNode(6);ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(1);
        a1.next = a2;a2.next = a3;

        p5.next = c1;a3.next = c1;
        ListNode firstCommonNode = findFirstCommonNode(p1, a1);
        System.out.println(firstCommonNode.val);
    }
}
