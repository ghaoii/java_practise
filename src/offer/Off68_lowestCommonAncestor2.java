package offer;

public class Off68_lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }

        TreeNode node1 = lowestCommonAncestor(root.left, p, q);
        TreeNode node2 = lowestCommonAncestor(root.right, p, q);

        if(node1 != null && node2 != null) {
            return root;
        }

        return node1 == null ? node2 : node1;
    }
}
