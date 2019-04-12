/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        // 尾节点
        ListNode reverseHead = null;
        // 前一个结点
        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null){
            ListNode next = currNode.next;
            if(next != null){
                reverseHead = next;
            }
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        return reverseHead;
    }
}
