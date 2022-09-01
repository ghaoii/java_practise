package bintree.leetcode;

import java.util.*;

public class Num102_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(list);
        }
        return ret;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if(root == null){
//            return ret;
//        }
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        TreeNode node = null;
//        while(!queue.isEmpty()){
//            List<Integer> data = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                node = queue.poll();
//                data.add(node.val);
//                if(node.left != null){
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(root.right);
//                }
//            }
//            ret.add(data);
//        }
//        return ret;
//    }
}
