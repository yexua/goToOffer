import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTree {

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
        PrintTree p = new PrintTree();
        ArrayList<ArrayList<Integer>> print = p.Print_2(t1);
        System.out.println(print);
    }

    /**
     * 运行时间：31ms
     * 占用内存：9644k
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        ArrayList<Integer> print = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode last = pRoot, nLast = null;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            print.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nLast = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                nLast = node.right;
            }
            if (last == node) {
                list.add(print);
                print = new ArrayList<>();
                last = nLast;
            }
        }
        return list;
    }

    /**
     * 运行时间：20ms
     * 占用内存：9648k
     */
    ArrayList<ArrayList<Integer>> Print_1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int start = 0, end = 1;
        while (!layer.isEmpty()) {
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if (cur.left != null) {
                layer.add(cur.left);
            }
            if (cur.right != null) {
                layer.add(cur.right);
            }
            if (start == end) {
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        return result;
    }

    /**
     * 运行时间：27ms
     * 占用内存：9464k
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print_2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<Integer> print;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            print = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                print.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(print);
        }
        return result;
    }
}
