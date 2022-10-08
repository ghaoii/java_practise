package offer;

public class Off26_IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return true;
        }

        if(A == null || B == null) {
            return false;
        }

        boolean flag = false;
        if(A.val == B.val) {
            flag = isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right);
        }

        if(flag) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
}
