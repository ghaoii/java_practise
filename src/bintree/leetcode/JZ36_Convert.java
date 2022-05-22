package bintree.leetcode;

public class JZ36_Convert {

    /**
     * 传入一个根结点，就能将该二叉树转为链表，并返回链表的头结点
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode leftHead = Convert(pRootOfTree.left);
        TreeNode leftTail = leftHead;
        while(leftTail != null && leftTail.right != null){
            //找到左链表的尾结点
            leftTail = leftTail.right;
        }
        if(leftTail != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode rightHead = Convert(pRootOfTree.right);
        if(rightHead != null){
            rightHead.left = pRootOfTree;
            pRootOfTree.right = rightHead;
        }
        return leftHead == null ? pRootOfTree : leftHead;
    }
}
