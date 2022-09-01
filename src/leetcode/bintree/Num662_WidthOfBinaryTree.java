package leetcode.bintree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num662_WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int max = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> number = new ArrayDeque<>();
        queue.offer(root);
        number.offer(1);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int left = number.peek();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int num = number.poll();
                if(i == size - 1) {
                    max = Math.max(max, num - left + 1);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                    number.offer(num * 2);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    number.offer(num * 2 + 1);
                }
            }
        }
        return max;
    }
}
