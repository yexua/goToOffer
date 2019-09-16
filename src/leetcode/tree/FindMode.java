package leetcode.tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
public class FindMode {

    private int maxCnt = 1;
    private int curCnt = 1;
    private TreeNode preNode = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNum = new ArrayList<>();
        inOrder(root, maxCntNum);
        int[] res = new int[maxCntNum.size()];
        int idx = 0;
        for (int i : maxCntNum) {
            res[idx++] = i;
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> num) {
        if (root == null) {
            return;
        }
        inOrder(root.left, num);
        if (preNode != null) {
            if (preNode.val == root.val) {
                curCnt++;
            } else {
                curCnt = 1;
            }
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            num.clear();
            num.add(root.val);
        } else if (curCnt == maxCnt) {
            num.add(root.val);
        }
        preNode = root;
        inOrder(root.right, num);
    }
}
