package offer;

public class Off26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) {
            return false;
        }
        boolean ret = false;

        if(A.val == B.val)
            ret = helper(A, B);
        if(!ret)
            ret = isSubStructure(A.left, B) || isSubStructure(A.right, B);

        return ret;
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null) {
            return false;
        }
        if(A.val == B.val) {
            return helper(A.left, B.left) && helper(A.right, B.right);
        }
        return false;
    }
}
