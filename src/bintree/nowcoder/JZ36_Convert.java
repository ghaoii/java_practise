package bintree.nowcoder;

import java.rmi.dgc.Lease;

public class JZ36_Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode leftTail = leftHead;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        pRootOfTree.left = leftTail;
        if(leftTail != null) {
            leftTail.right = pRootOfTree;
        }
        TreeNode rightHead = Convert(pRootOfTree.right);
        pRootOfTree.right = rightHead;
        if(rightHead != null) {
            rightHead.left = pRootOfTree;
        }
        return leftHead == null ? pRootOfTree : leftHead;
    }

    /**
     * 传入一个根结点，就能将这颗树转化为双向链表，并返回双向链表的头结点
     * @param pRootOfTree
     * @return
     */
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null){
//            return null;
//        }
//        TreeNode LeftHead = Convert(pRootOfTree.left);
//        TreeNode LeftTail = LeftHead;
//        while(LeftTail != null && LeftTail.right != null){
//            LeftTail = LeftTail.right;
//        }
//        if(LeftTail != null){
//            LeftTail.right = pRootOfTree;
//            pRootOfTree.left = LeftTail;
//        }
//        TreeNode rightHead = Convert(pRootOfTree.right);
//        if(rightHead != null){
//            pRootOfTree.right = rightHead;
//            rightHead.left = pRootOfTree;
//        }
//        return LeftHead == null ? pRootOfTree : LeftHead;
//    }
}
