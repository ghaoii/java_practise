package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num98_IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long l, long r) {
        if(root == null){
            return true;
        }
        if(root.val <= l || root.val >= r){
            return false;
        }
        return isValidBST(root.left, l, root.val) && isValidBST(root.right, root.val, r);
    }

    //递归
//    public boolean isValidBST(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode cur = root;
//        TreeNode prev = null;
//
//        while(cur != null || !stack.isEmpty()){
//            while(cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if(prev != null && prev.val >= cur.val){
//                return false;
//            }
//            prev = cur;
//            cur = cur.right;
//        }
//        return true;
//    }
}
