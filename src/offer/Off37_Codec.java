package offer;

public class Off37_Codec {
    // 序列化二叉树
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(root.val).append(",");
        if(root.left != null) {
            serialize(root.left, sb);
        }else {
            sb.append("#,");
        }

        if(root.right != null) {
            serialize(root.right, sb);
        }else {
            sb.append("#,");
        }
    }

    // 反序列化二叉树
    int index = 0;

    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        index = 0;
        return deserializeHelper(data.split(","));
    }

    private TreeNode deserializeHelper(String[] data) {
        if(index >= data.length) {
            return null;
        }

        if(data[index].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[index]));
        index++;
        root.left = deserializeHelper(data);
        index++;
        root.right = deserializeHelper(data);

        return root;
    }
}
