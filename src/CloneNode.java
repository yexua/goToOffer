/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneNode {
    /*
     * 1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
     * 2、遍历链表，A1->random = A->random->next;
     * 3、将链表拆分成原链表和复制后的链表
     */
    public static RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currNode = pHead;

        // 第一步，复制每个节点
        while (currNode != null) {
            RandomListNode cNode = new RandomListNode(currNode.label);
            cNode.next = currNode.next;
            cNode.random = currNode.random;

            currNode.next = cNode;
            currNode = cNode.next;
        }
        // 第二步，复制random节点
        currNode = pHead;
        while (currNode != null) {
            RandomListNode cNode = currNode.next;
            if (currNode.random != null) {
                cNode.random = currNode.random.next;
            }
            currNode = cNode.next;
        }
        // 第三步，将链表拆分为原链表和复制后的链表
        RandomListNode cloneHead = pHead.next;
        currNode = pHead;
        RandomListNode tmp;
        while (currNode.next != null) {
            tmp = currNode.next;
            currNode.next = tmp.next;
            currNode = tmp;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        RandomListNode p1 = new RandomListNode(1);
        RandomListNode p2 = new RandomListNode(2);
        RandomListNode p3 = new RandomListNode(3);
        RandomListNode p4 = new RandomListNode(4);
        RandomListNode p5 = new RandomListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        p1.random = p5;
        p2.random = p1;
        p4.random = p2;
        p5.random = p3;
        RandomListNode clone = clone(p1);
        System.out.println(clone.label);

    }
}
