import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null) {
            return t1.val == t2.val
                    && isSymmetrical(t1.left, t2.right)
                    && isSymmetrical(t1.right, t2.left);
        }
        return false;
    }

    boolean isSymmetricalDFS(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.empty()) {
            //成对取出
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null) continue;
            if (right == null || left == null) return false;
            if (right.val != left.val) return false;
            // 成对插入
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);

        }
        return true;
    }
}
