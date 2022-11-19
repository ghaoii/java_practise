package offer;

import java.util.ArrayList;
import java.util.List;

public class Off54_KthLargest {
    private int n = 0;
    public int kthLargest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        int ret = kthLargest(root.right, k);
        if(ret != -1) {
            return ret;
        }
        n++;
        if(n == k) {
            return root.val;
        }
        return kthLargest(root.left, k);
    }

}
