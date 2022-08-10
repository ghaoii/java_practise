package leetcode.bintree;

import java.util.HashMap;
import java.util.Map;

public class Num437_PathSum {
    private int count = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1000000000);
        TreeNode root = node;
        root = root.left = new TreeNode(1000000000);
        root = root.right = new TreeNode(294967296);
        root = root.right = new TreeNode(1000000000);
        root = root.right = new TreeNode(1000000000);
        root = root.right = new TreeNode(1000000000);
        Num437_PathSum test = new Num437_PathSum();
        int count = test.pathSum(node, 0);
        System.out.println(count);
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        // 根节点的前缀和为0
        // 因为可能存在从根节点一直到某个结点的前缀和正好等于targetSum
        map.put(0L, 1);
        return dfs(root, map, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> map, long sum, int target) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        sum += root.val;
        count += map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += dfs(root.left, map, sum, target);
        count += dfs(root.right, map, sum, target);
        map.put(sum, map.get(sum) - 1);
        return count;
    }


//    public int pathSum(TreeNode root, int targetSum) {
//        if(root == null) {
//            return 0;
//        }
//        return search(root, 0, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
//    }
//
//    private int search(TreeNode root, long sum, int target) {
//        if(root == null) {
//            return 0;
//        }
//        sum += root.val;
//        if(sum == target) {
//            count++;
//        }
//        return count + search(root.left, sum, target) + search(root.right, sum, target);
//    }
}
