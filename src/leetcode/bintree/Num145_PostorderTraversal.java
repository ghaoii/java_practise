package leetcode.bintree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        TreeNode prev = null;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode cur = stack.pop();
            if(cur.right == null || cur.right == prev) {
                list.add(cur.val);
                prev = cur;
            }else {
                stack.push(cur);
                node = cur.right;
            }
        }
        return list;
    }
}
