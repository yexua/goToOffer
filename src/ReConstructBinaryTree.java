/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 注意：你可以假设树中没有重复的元素
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        ReConstructBinaryTree r = new ReConstructBinaryTree();
        r.reConstructBinaryTree(preorder, inorder);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return helper(pre, 0, pre.length - 1, in, 0, in.length -1);
    }

    private TreeNode helper(int[] pre, int i, int j, int[] in, int p, int q) {
        if (i > j || p > q) {
            return null;
        }
        TreeNode root = new TreeNode(pre[i]);
        int index;
        for (index = 0; index < q; index++) {
            if (in[index] == pre[i]) {
                break;
            }
        }
        root.left = helper(pre, i + 1, i + index - p, in, p, index - 1);
        root.right = helper(pre, i + index - p + 1, j, in, index + 1, q);
        return root;
    }
}
