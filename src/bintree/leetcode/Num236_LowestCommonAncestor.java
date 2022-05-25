package bintree.leetcode;

public class Num236_LowestCommonAncestor {
    public TreeNode ret = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA(root, p, q);
        return ret;
    }

    private boolean LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int count = 0;
        count += (root == p || root == q ? 1 : 0);
        count += LCA(root.left, p, q) ? 1 : 0;
        count += LCA(root.right, p, q) ? 1 : 0;
        if(count == 2){
            ret = root;
        }
        return count >= 1;
    }
}
