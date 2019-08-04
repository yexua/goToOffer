/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {
    int index = -1;

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        SerializeTree s = new SerializeTree();
        System.out.println(s.Serialize(t1));
        String str = "8,6,5,#,#,7,#,#,10,9,#,#,11,#,#";
        TreeNode deserialize = s.Deserialize(str);
        System.out.println(deserialize.val);
        System.out.println("ssss");
    }

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        return DeserializeCore(s);
    }

    TreeNode DeserializeCore(String[] s) {
        index++;
        if (index > s.length) {
            return null;
        }
        TreeNode node = null;
        if (!s[index].equals("#")) {
            node = new TreeNode(Integer.parseInt(s[index]));
            node.left = DeserializeCore(s);
            node.right = DeserializeCore(s);
        }
        return node;
    }
}
