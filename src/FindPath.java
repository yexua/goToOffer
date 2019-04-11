import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null) return list;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            list.add(new ArrayList<>(path));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(path.size()-1);
        return list;
    }
}
