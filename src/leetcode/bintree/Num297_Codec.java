package leetcode.bintree;

public class Num297_Codec {
    int index = 0;
    public static void main(String[] args) {
        Num297_Codec test = new Num297_Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = test.serialize(root);
        TreeNode newRoot = test.deserialize(str);
        System.out.println();
    }

    // 将二叉树转化为字符串
    public String serialize(TreeNode root) {
        if(root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//        StringBuilder sb = new StringBuilder();
//        serializeInternal(root, sb);
//        sb.delete(sb.length() - 1, sb.length());
//        return sb.toString();
    }

    private void serializeInternal(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serializeInternal(root.left, sb);
        serializeInternal(root.right, sb);
    }

    // 将字符串转化为二叉树
    public TreeNode deserialize(String data) {
        if(data == null) {
            return null;
        }
        String[] str = data.split(",");
        return deserializeInternal(str);
    }

    private TreeNode deserializeInternal(String[] str) {
        if(index >= str.length) {
            return null;
        }
        if("#".equals(str[index])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[index]));
        index++;
        root.left = deserializeInternal(str);
        index++;
        root.right = deserializeInternal(str);
        return root;
    }
}
