package leetcode;

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
        if(root == null) {
            return 0;
        }
        return search(root, 0, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int search(TreeNode root, long sum, int target) {
        if(root == null) {
            return 0;
        }
        sum += root.val;
        if(sum == target) {
            count++;
        }
        return count + search(root.left, sum, target) + search(root.right, sum, target);
    }
}
