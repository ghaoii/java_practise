package leetcode.bintree;

import leetcode.bintree.TreeNode;

public class Num101_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }

//    public boolean isSymmetric(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        return isMirror(root.left, root.right);
//    }
//
//    private boolean isMirror(TreeNode p, TreeNode q) {
//        if(p == null && q == null) {
//            return true;
//        }
//        if(p == null || q == null) {
//            return false;
//        }
//        return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
//    }
}
