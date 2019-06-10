import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        find(root, target, new ArrayList<>());
        return res;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        if (root.left != null) {
            find(root.left, target - root.val, list);
        }
        if (root.right != null) {
            find(root.right, target - root.val, list);
        }

        list.remove(list.size() - 1);
    }
}
