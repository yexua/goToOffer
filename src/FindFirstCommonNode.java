/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != l2) {
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }

    public ListNode findFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int count1 = 0;
        ListNode p1 = pHead1;
        while (p1 != null) {
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            p2 = p2.next;
            count2++;
        }
        int flag = count1 - count2;
        if (flag > 0) {
            while (flag > 0) {
                pHead1 = pHead1.next;
                flag--;
            }
            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
            return pHead1;
        } else {
            while (flag < 0) {
                pHead2 = pHead2.next;
                flag++;
            }
            while (pHead1 != pHead2) {
                pHead2 = pHead2.next;
                pHead1 = pHead1.next;
            }
            return pHead1;
        }
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(8);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(6);
        ListNode p5 = new ListNode(7);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(4);
        a1.next = a2;
        a2.next = p3;


        ListNode firstCommonNode = findFirstCommonNode(p1, a1);
        System.out.println(firstCommonNode.val);
    }
}
