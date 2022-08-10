package leetcode.bintree;

import leetcode.bintree.TreeNode;

public class Num105_BuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        if(left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        int pos = search(inorder, left, right, preorder[index]);
        index++;
        root.left = buildTree(preorder, inorder, left, pos - 1);
        root.right = buildTree(preorder, inorder, pos + 1, right);
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
}
