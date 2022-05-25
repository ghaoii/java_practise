package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num101_IsSymmetric {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if(p.val == q.val){
                if(p.left != null && q.right != null){
                    queue.offer(p.left);
                    queue.offer(q.right);
                }else if(p.left != null || q.right != null){
                    return false;
                }

                if(p.right != null && q.left != null){
                    queue.offer(p.right);
                    queue.offer(q.left);
                }else if(p.right != null || q.left != null){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }

//    /**
//     * 传入一颗树的根结点，就能判断这颗树是否是对称二叉树
//     * @param root
//     * @return
//     */
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        if(root.left == null && root.right == null){
//            return true;
//        }
//        if(root.left == null || root.right == null){
//            return false;
//        }
//        return mirror(root.left, root.right);
//
//    }
//
//    /**
//     * 传入两颗树的根结点，就能判断两颗树是否对称
//     * @param p
//     * @param q
//     * @return
//     */
//    private boolean mirror(TreeNode p, TreeNode q){
//        if(p == null && q == null){
//            return true;
//        }
//        if(p == null || q == null){
//            return false;
//        }
//        return p.val == q.val && mirror(p.left, q.right) && mirror(p.right, q.left);
//    }
}
