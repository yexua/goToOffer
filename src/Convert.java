/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    private static TreeNode preNode = null;

    public static TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convertNode(pRootOfTree);
        TreeNode head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static void convertNode(TreeNode node) {
        // 遍历左子树
        if (node.left != null) {
            convertNode(node.left);
        }
        node.left = preNode;
        if (preNode != null) {
            preNode.right = node;
        }
        preNode = node;
        // 遍历右子树
        if (node.right != null) {
            convertNode(node.right);
        }
    }

    public static void main(String[] args) {

        test1();
        test2();
    }

    public static void test1() {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(10);
        TreeNode t5 = new TreeNode(12);
        TreeNode t6 = new TreeNode(14);
        TreeNode t7 = new TreeNode(16);
        t2.left = t1;
        t2.right = t3;
        t4.left = t2;
        t4.right = t6;
        t6.left = t5;
        t6.right = t7;
        TreeNode convert = convert(t4);
        System.out.println(convert.val);
    }

    public static void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t5.left = t4;
        t4.left = t3;
        t3.left = t2;
        t2.left = t1;
        TreeNode convert = convert(t5);
        System.out.println(convert.val);
    }
}
