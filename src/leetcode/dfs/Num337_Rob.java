package leetcode.dfs;


import java.util.HashMap;
import java.util.Map;

public class Num337_Rob {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dfs(TreeNode root) {
        int[] ret = new int[2];
        if(root == null) {
            return ret;
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 偷的情况 = 当前val + 左右子树不偷的情况
        ret[0] = root.val + left[1] +right[1];
        // 不偷的情况 = 分别取左右子树偷或者不偷中的最大值
        ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ret;
    }
}

//public class Num337_Rob {
//    Map<TreeNode, Integer> map = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        return dfs(root, true);
//    }
//
//    private int dfs(TreeNode root, boolean canRob) {
//        if(root == null) {
//            return 0;
//        }
//        int max = 0;
//        if(canRob && map.containsKey(root)) {
//            return map.get(root);
//        }
//        if(canRob) {
//            max = root.val + dfs(root.left, false) + dfs(root.right, false);
//        }
//        max = Math.max(max, dfs(root.left, true) + dfs(root.right, true));
//        if(canRob) {
//            map.put(root, max);
//        }
//        return max;
//    }
//}
