package offer;

import java.util.ArrayList;
import java.util.List;

public class Off34_PathSum {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null) {
            return ret;
        }
        helper(root, target, new ArrayList<>());
        return ret;
    }

    public void helper(TreeNode root, int target, List<Integer> list) {
        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                ret.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }

        if(root.left != null) {
            helper(root.left, target - root.val, list);
        }
        if(root.right != null) {
            helper(root.right, target - root.val, list);
        }

        list.remove(list.size() - 1);
    }
}
