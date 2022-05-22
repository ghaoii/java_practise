package bintree.binsearchtree;

import java.util.NoSuchElementException;

public class MyBinSearchTree {
    private TreeNode root;
    private int size;


    public void add(int val){
        root = add(root, val);
        size++;
    }

    /**
     * 传入一个一棵树的根结点和元素值val，就能在BST中插入val，并返回插入后的树根结点
     * @param root
     * @return
     */
    private TreeNode add(TreeNode root, int val){
        if(root == null){
            //如果根结点为空，直接返回新结点
            return new TreeNode(val);
        }
        if(val < root.val){
            root.left = add(root.left, val);
        }
        if(val > root.val){
            root.right = add(root.right, val);
        }
        return root;
    }

    public boolean contains(int val){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot search!");
        }
        return contains(root, val);
    }

    /**
     * 传入一棵树的根结点和val，就能判断该BST是否包含val
     * @param root
     * @param val
     * @return
     */
    private boolean contains(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(val == root.val){
            return true;
        }
        if(val < root.val){
            return contains(root.left, val);
        }
        return contains(root.right, val);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    /**
     * 先序遍历打印BST
     * @param root
     * @param height
     * @param sb
     * @return
     */
    private void generateBSTString(TreeNode root, int height, StringBuilder sb){
        if(root == null){
            return;
        }
        //打印当前结点
        sb.append(generateHeight(height)).append(root.val).append("\n");
        generateBSTString(root.left, height + 1, sb );
        generateBSTString(root.right, height + 1, sb );
    }

    private String generateHeight(int height){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public int findMin(){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot search!");
        }
        return min(root).val;
    }

    /**
     * 传入一颗BST的根结点，就能找到最小值，并返回其结点
     * @param root
     * @return
     */
    private TreeNode min(TreeNode root){
        if(root.left == null){
            //如果根结点没有左子树，那么根结点就是最小值
            return root;
        }
        return min(root.left);
    }

    public int findMax(){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot search!");
        }
        return max(root).val;
    }

    /**
     * 传入BST的根结点，就能找到大嘴值，并返回其结点
     * @param root
     * @return
     */
    private TreeNode max(TreeNode root){
        if(root.right == null){
            //如果根结点没有右子树，那么根结点本身就是最大值
            return root;
        }
        return max(root.right);
    }

    public int removeMin(){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot remove!");
        }
        int min = min(root).val;
        root = removeMin(root);
        return min;
    }

    /**
     * 传入BST的根结点，就能删除BST中的最小值，并返回删除后的树根结点
     * @param root
     * @return
     */
    private TreeNode removeMin(TreeNode root){
        if(root.left == null){
            //如果根结点没有左子树，那么根结点本身就是待删除的最小值
            TreeNode node = root.right;
            root.right = root = null;
            size--;
            return node;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public int removeMax(){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot remove!");
        }
        int max = max(root).val;
        root = removeMax(root);
        return max;
    }

    /**
     * 传入BST的根结点，就能删除BST中的最大值，并返回删除后的树根结点
     * @param root
     * @return
     */
    private TreeNode removeMax(TreeNode root){
        if(root.right == null){
            //此时根结点就是最大值
            TreeNode node = root.left;
            root.left = root = null;
            size--;
            return node;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public void remove(int val){
        if(size == 0){
            throw new NoSuchElementException("BST is empty! cannot remove!");
        }
        root = remove(root, val);
    }

    /**
     * 传入BST的根结点和待删除元素val，就能删除BST中的val，并返回删除后的树根结点
     * @param root
     * @param val
     * @return
     */
    private TreeNode remove(TreeNode root, int val){
        if(root == null){
            //走到null的时候，说明遍历完BST了，也没有找到val，即val不存在
            throw new NoSuchElementException("val does not exist! cannot remove!");
        }
        if(root.val == val){
            //根结点就是待删除元素
            if(root.left == null){
                //类似于删除最小值
                TreeNode node = root.right;
                root.right = root = null;
                size--;
                return node;
            }
            if(root.right == null){
                //类似于删除最大值
                TreeNode node = root.left;
                root.left = root = null;
                size--;
                return node;
            }
            //此时左右子树都存在，则需要找到继承者(前驱或这后继都可以)
            TreeNode successor = max(root.left);
            //1. 删除继承者原来的位置，并连接左子树
            successor.left = removeMax(root.left);
            //2. 连接右子树
            successor.right = root.right;
            //3. 垃圾回收，并返回删除后的根结点
            root.left = root.right = root = null;
            return successor;
        }
        //此时根结点不是待删除元素
        if(val < root.val){
            //把左子树的删除交给子函数
            root.left = remove(root.left, val);
            return root;
        }
        //此时，val肯定小于根结点，因此把右子树的删除交给子函数
        root.right = remove(root.right, val);
        return root;
    }

}
