package bintree.leetcode;

public class Num106_InAndPostBuildTree {
    private int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int left = 0;
        int right = postorder.length - 1;
        postorder = reverse(postorder);
        return build(inorder, postorder, left, right);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(index == postorder.length || left > right ){
            return null;
        }
        int pos = findIndex(inorder, postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index++;
        root.right = build(inorder, postorder, pos + 1, right);
        root.left = build(inorder, postorder, left, pos - 1);
        return root;
    }

    private int[] reverse(int[] root){
        int left = 0;
        int right = root.length - 1;
        while(left < right){
            int tmp =root[left];
            root[left] = root[right];
            root[right] = tmp;
            left++;
            right--;
        }
        return root;
    }

    private int findIndex(int[] inorder, int val){
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }
}
