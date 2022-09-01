package leetcode.bintree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Num1028_RecoverFromPreorder {
    int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        List<Integer> nodeVal = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(0);// 第一个结点的高度
        int len = traversal.length();
        int i = 0;
        while (i < len) {
            if(traversal.charAt(i) != '-') {
                int num = 0;
                while(i < len && traversal.charAt(i) != '-') {
                    num = num * 10 + (traversal.charAt(i) - '0');
                    i++;
                }
                nodeVal.add(num);
            }else {
                int count = 0;
                while(i < len && traversal.charAt(i) == '-') {
                    count++;
                    i++;
                }
                level.add(count);
            }
        }
        return build(nodeVal, level, 0);
    }

    private TreeNode build(List<Integer> nodeVal, List<Integer> level, int height) {
        TreeNode root = new TreeNode(nodeVal.get(index));
        index++;
        if(index == nodeVal.size()) {
            return root;
        }
        // 判断下一个结点是否是子结点，通过高度来判断
        if(level.get(index) == height + 1) {
            // 如果下个结点的高度是当前高度+1，说明是子结点
            root.left = build(nodeVal, level,height + 1);
        }
        if(index == nodeVal.size()) {
            return root;
        }
        if(level.get(index) == height + 1) {
            root.right = build(nodeVal, level, height + 1);
        }
        return root;
    }
}
