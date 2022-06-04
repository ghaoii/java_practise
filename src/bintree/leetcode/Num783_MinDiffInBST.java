package bintree.leetcode;

public class Num783_MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left = Integer.MAX_VALUE;
        if(root.left != null){
            TreeNode node = root.left;
            while(node.right != null){
                node = node.right;
            }
            left = Math.min(minDiffInBST(root.left), root.val - node.val);
        }
        int right = Integer.MAX_VALUE;
        if(root.right != null){
            TreeNode node = root.right;
            while(node.left != null){
                node = node.left;
            }
            right = Math.min(minDiffInBST(root.right), node.val - root.val);
        }
        return Math.min(left, right);
    }

    /**
     * 传入BST的根结点和比较值，返回该树中与比较值相差最小的元素值
     * @param root
     * @param cmpVal
     * @return
     */
    private int minDiffInBSTInternal(TreeNode root, int cmpVal) {
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int left = minDiffInBSTInternal(root.left, root.val);
        int right = minDiffInBSTInternal(root.right, root.val);
        if(left == right){
            return root.val;
        }
        if(Math.abs(cmpVal - left) < Math.abs(cmpVal - right)){
            return left;
        }
        return right;
    }
}
