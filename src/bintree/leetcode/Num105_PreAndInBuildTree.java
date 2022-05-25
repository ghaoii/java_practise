package bintree.leetcode;

public class Num105_PreAndInBuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right){
        if(index == preorder.length || left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, left, findIndex(inorder, root.val) - 1);
        root.right = build(preorder, inorder, findIndex(inorder, root.val) + 1, right);
        return root;
    }

    private int findIndex(int[] inorder, int val){
        for (int i = 0; i < inorder.length; i++) {
            if(val == inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
