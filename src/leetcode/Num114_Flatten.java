package leetcode;

public class Num114_Flatten {

    public void flatten(TreeNode root) {
        helper(root);
    }

    // 传入一棵树的根节点，就能把这棵树转化为链表，并返回头结点
    private TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        if(left == null) {
            root.right = helper(root.right);
        }else {
            TreeNode leftTail = root.left;
            while(leftTail.right != null) {
                leftTail = leftTail.right;
            }
            TreeNode right = helper(root.right);
            root.left = null;
            root.right = left;
            leftTail.right = right;
        }
        return root;
    }
}
