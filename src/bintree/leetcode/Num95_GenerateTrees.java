package bintree.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num95_GenerateTrees {
    public static void main(String[] args) {
        generateTrees(3);
    }

    public static List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    /**
     * 传入结点区间，返回该区间内所有BST的构建方式
     * @param start
     * @param end
     * @return
     */
    private static List<TreeNode> build(int start, int end) {
        List<TreeNode> ret = new ArrayList<>();
        if(start > end){
            ret.add(null);
            return ret;
        }
        if(start == end){
            TreeNode root = new TreeNode(start);
            ret.add(root);
            return ret;
        }
        for (int i = start; i <= end; i++) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> left = build(start, i -  1);
            List<TreeNode> right = build(i + 1, end);
            for(TreeNode leftRoot : left){
                for(TreeNode rightRoot : right){
                    root.left = leftRoot;
                    root.right = rightRoot;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
