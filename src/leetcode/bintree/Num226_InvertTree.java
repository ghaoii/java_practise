package leetcode.bintree;

public class Num226_InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            return root;
        }

        if(root.left == null) {
            invertTree(root.right);
            root.left = root.right;
            root.right = null;
        }else if(root.right == null) {
            invertTree(root.left);
            root.right = root.left;
            root.left = null;
        }else {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }
}
