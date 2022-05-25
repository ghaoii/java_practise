package bintree.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num104_MaxDepth {
    /**
     * 传入一颗树的根结点，就能返回这颗树的高度
     * @param root
     * @return
     */
//    public int maxDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }

    /**
     * 递归解决 - leetcode解决超出时间限制
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(root.left);
                }
                if(cur.right != null){
                    queue.offer(root.right);
                }
            }
            height++;
        }
        return height;
    }
}
