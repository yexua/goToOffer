/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode fHead = head;
        ListNode sHead;
        for (int i = 0; i < k - 1; i++) {
            if (head.next != null) {
                fHead = fHead.next;
            } else {
                return null;
            }
        }
        sHead = head;
        while (fHead.next != null) {
            fHead = fHead.next;
            sHead = sHead.next;
        }
        return sHead;
    }
}
