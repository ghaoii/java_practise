package bintree.leetcode;


public class Num606_Tree2Str {
    public String tree2str(TreeNode root) {
        if(root == null){
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
