package bintree.leetcode;

public class Num100_IsSameTree {
    /**
     * 传入两颗树的根结点，就能判断两颗树是否相同
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null &&  q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
