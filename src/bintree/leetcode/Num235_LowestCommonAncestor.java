package bintree.leetcode;

public class Num235_LowestCommonAncestor {
    TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        findLca(root,p,q);
        return ret;
    }

    private boolean findLca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        int left = findLca(root.left, p, q) ? 1 : 0;
        int right = findLca(root.right, p, q) ? 1 : 0;
        int mid = root == p || root == q ? 1 : 0;
        if(left + right + mid == 2){
            ret = root;
        }
        return left + right + mid > 0;
    }

}
