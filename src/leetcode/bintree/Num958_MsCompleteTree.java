package leetcode.bintree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num958_MsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(flag) {
                // 第一阶段，结点可以有子树
                if(node.left != null && node.right != null) {
                    // 左右子树均存在，继续判断
                    queue.offer(node.left);
                    queue.offer(node.right);
                }else if(node.right != null) {
                    // 如果只有右子树没有左子树，一定不是完全二叉树
                    return false;
                }else if(node.left != null){
                    // 如果只有左子树没有右子树，则进入第二阶段
                    queue.offer(node.left);
                    flag = false;
                }else {
                    // 如果没有子树，则进入第二阶段
                    flag = false;
                }
            }else {
                // 第二阶段，结点不允许有子树
                if(node.left != null || node.right != null) {
                    return false;
                }
            }
        }
        // 如果整颗树遍历完了，就说明是完全二叉树
        return true;
    }
}
