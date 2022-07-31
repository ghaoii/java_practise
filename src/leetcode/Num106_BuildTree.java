package leetcode;

public class Num106_BuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        reverse(postorder);
        TreeNode root = buildTree(inorder, postorder, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int left, int right) {
        if(left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int pos = search(inorder, left, right, postorder[index]);
        index++;
        root.right = buildTree(inorder, postorder, pos + 1, right);
        root.left = buildTree(inorder, postorder, left, pos - 1);
        return root;
    }

    private int search(int[] inorder, int left, int right, int val) {
        for(int i = left; i <= right; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    private void reverse(int[] postorder) {
        int left = 0;
        int right = postorder.length - 1;
        while(left < right) {
            int temp = postorder[left];
            postorder[left] = postorder[right];
            postorder[right] = temp;
            left++;
            right--;
        }
    }
}
