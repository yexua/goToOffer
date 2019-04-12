/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeNode {
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode currNode = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                currNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                currNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            currNode = currNode.next;
        }
        if(list1 !=null){
            currNode.next = list1;
        }
        if(list2 != null){
            currNode.next = list2;
        }
        return head.next;
    }
}
