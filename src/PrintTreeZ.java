import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreeZ {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        PrintTreeZ p = new PrintTreeZ();
        ArrayList<ArrayList<Integer>> print = p.Print(t1);
        System.out.println(print);
    }

    /**
     * 运行时间：30ms
     * 占用内存：9424k
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        ArrayList<Integer> print = new ArrayList<>();
        Stack<TreeNode>[] s = new Stack[2];
        for (int i = 0; i < s.length; i++) {
            s[i] = new Stack<>();
        }
        int current = 0, next = 1;
        s[current].push(pRoot);
        TreeNode temp;
        while (!s[0].isEmpty() || !s[1].isEmpty()) {
            temp = s[current].pop();
            print.add(temp.val);
            if (current == 0) {
                if (temp.left != null) {
                    s[next].push(temp.left);
                }
                if (temp.right != null) {
                    s[next].push(temp.right);
                }
            } else {
                if (temp.right != null) {
                    s[next].push(temp.right);
                }
                if (temp.left != null) {
                    s[next].push(temp.left);
                }
            }
            if (s[current].isEmpty()) {
                list.add(print);
                print = new ArrayList<>();
                current = 1 - current;
                next = 1 - next;
            }
        }
        return list;
    }
}
