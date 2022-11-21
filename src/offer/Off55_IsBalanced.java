package offer;

public class Off55_IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}