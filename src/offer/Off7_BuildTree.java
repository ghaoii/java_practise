package offer;

public class Off7_BuildTree {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if(left > right || index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int cur = searchNode(inorder, preorder[index], left, right);
        index++;
        root.left = buildTree(preorder, inorder, left, cur - 1);
        root.right = buildTree(preorder, inorder, cur + 1, right);
        return root;
    }

    private int searchNode(int[] inorder, int val, int left, int right) {
        for (int i = left; i <= right; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
