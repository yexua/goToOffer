package leetcode.tree;

import leetcode.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * (间隔遍历)
 */
public class Rob {

    public int rob_(TreeNode root) {
        int[] max = doRob(root);
        return Math.max(max[0], max[1]);
    }
    private int[] doRob(TreeNode root){
        int[] res = new int[2];
        if(root == null)
            return res;
        int[] left = doRob(root.left);
        int[] right = doRob(root.right);
        //不包含根节点，最大值为两个子树的最大值之和
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //包含根节点，最大值为两个子树不包含根节点的最大值加上根节点的值
        res[1] = left[0] + right[0] + root.val;
        return res;
    }

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }
        postorder(root);
        return root.val;
    }

    public void postorder(TreeNode root){
        if (root.left!=null){
            postorder(root.left);
        }
        if (root.right!=null){
            postorder(root.right);
        }
        int res1=0;
        int res2=root.val;
        if (root.left!=null){
            res1=res1+root.left.val;
            if (root.left.left!=null){
                res2=res2+root.left.left.val;
            }
            if (root.left.right!=null){
                res2=res2+root.left.right.val;
            }
        }
        if (root.right!=null){
            res1=res1+root.right.val;
            if (root.right.left!=null){
                res2=res2+root.right.left.val;
            }
            if (root.right.right!=null){
                res2=res2+root.right.right.val;
            }
        }
        root.val=Math.max(res1, res2);
    }
}
