package leetcode.bintree;

import leetcode.bintree.TreeNode;

public class Num110_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
