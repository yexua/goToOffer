import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class printListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<Integer> stack = new Stack();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        while (stack.size() > 0)
            list.add(stack.pop());
        return list;
    }
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead_re(ListNode listNode) {

        if(listNode !=null){
            printListFromTailToHead_re(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ArrayList<Integer> integers = printListFromTailToHead(l1);
        final ArrayList<Integer> list = printListFromTailToHead_re(l1);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d\t", list.get(i));
        }
    }
}
