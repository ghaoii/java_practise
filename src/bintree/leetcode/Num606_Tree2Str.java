package bintree.leetcode;


public class Num606_Tree2Str {

    /**
     * 传入一棵树的根结点，就能把这颗树转换为字符串，并返回
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if(root == null){
            //如果没有直接返回null；
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if(root.left != null){
            sb.append("(");
            sb.append(tree2str(root.left));
            sb.append(")");
        }else{
            if(root.right != null){
                //左边没有，右边有，不能省
                sb.append("()");
            }
        }
        if(root.right != null){
            sb.append("(");
            sb.append(tree2str(root.right));
            sb.append(")");
        }

        return sb.toString();
    }
}
