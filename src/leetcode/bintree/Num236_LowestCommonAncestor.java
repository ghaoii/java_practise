package leetcode.bintree;

import leetcode.bintree.TreeNode;

public class Num236_LowestCommonAncestor {
    TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ret;
    }
    private int helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return 0;
        }
        int mid = root == q || root == p ? 1 : 0;
        int left = helper(root.left, p, q);
        int right = helper(root.right, p, q);
        int sum = mid + left + right;
        if(sum == 2) {
            ret = root;
        }
        return sum > 0 ? 1 : 0;
    }

//    TreeNode ret;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        helper(root, p, q);
//        return ret;
//    }
//    private int helper(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null) {
//            return 0;
//        }
//        int a = root == p || root == q ? 1 : 0;
//        int b = helper(root.left, p, q);
//        int c = helper(root.right, p, q);
//        int sum = a + b + c;
//        if(sum == 2) {
//            ret = root;
//        }
//        return sum > 0 ? 1 : 0;
//    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null || root == p || root == q) {
//            // 由于一定存在p和q，因此直接返回root，如果为null的话，说明该子树中没有p和q
//            return root;
//        }
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if(left == null) {
//            return right;
//        }
//        if(right == null) {
//            return left;
//        }
//        return root;
//    }
}
