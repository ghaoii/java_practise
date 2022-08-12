package leetcode.bintree;

public class Num124_MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    /**
     * 递归计算当前子树的最大路径和
     * @param root
     */
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 有可能返回一个负数，反而拖了最大路径和的后退，因此还不如不加
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 计算并更新当前子树中的最大路径和
        max = Math.max(max, root.val + left + right);
        // 返回经过当前子树的最大路径和给父结点(这里的路径和是只能是单支的，因为要给父结点用)
        // 这里如果子树的左右子树都是负数，就只会返回当前结点值，如果当前结点值也是负数，就不会被父结点使用
        return root.val + Math.max(left, right);
    }
}
