package offer;

public class Off33_VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if(left >= right) {
            return true;
        }

        int index = -1;
        for (int i = left; i < right; i++) {
            // 找到左右子树的分隔点：左子树全部小于根节点，右子树全部大于根节点
            // 因此当找到一个元素大于等于的根节点的时候，就说明在此之前的都是左子树结点
            if(postorder[i] >= postorder[right]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            // 说明所有元素都在左子树，直接返回true
            return helper(postorder, left, right - 1);
        }

        // 存在右子树的情况
        for (int i = index; i < right; i++) {
            if(postorder[i] < postorder[right]) {
                // 如果右子树结点中有一个元素小于根节点，则不可能是BST
                return false;
            }
        }

        // 递归判断左右子树的合法性
        return helper(postorder, left, index - 1) && helper(postorder, index, right - 1);
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 7, 5};
        Off33_VerifyPostorder test = new Off33_VerifyPostorder();
        System.out.println(test.verifyPostorder(arr));
    }
}
