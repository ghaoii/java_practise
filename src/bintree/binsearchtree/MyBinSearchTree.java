package bintree.binsearchtree;

import java.util.NoSuchElementException;

public class MyBinSearchTree {
    TreeNode root;
    int size;

    public void add(int val) {
        root = add(root, val);
        size++;
    }

    private TreeNode add(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val < root.val) {
            root.left = add(root.left, val);
        }else {
            root.right = add(root.right, val);
        }
        return root;
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(TreeNode root, int val) {
        if(root == null) {
            return false;
        }
        if(root.val == val) {
            return true;
        }
        return contains(root.left, val) || contains(root.right, val);
    }

    public int getMin() {
        if(root == null) {
            throw new NoSuchElementException("BST is empty!");
        }
       return getMin(root).val;
    }

    private TreeNode getMin(TreeNode root) {
        TreeNode node = root;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        if (root == null) {
            throw new NoSuchElementException("BST is empty!");
        }
        return getMax(root).val;
    }

    private TreeNode getMax(TreeNode root) {
        TreeNode node = root;
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    public int removeMin() {
        if(root == null) {
            throw new NoSuchElementException("BST is empty!");
        }
        int min = getMin();
        root = removeMin(root);
        size--;
        return min;
    }

    private TreeNode removeMin(TreeNode root) {
        if(root.left == null) {
            return root.right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public int removeMax() {
        if(root == null) {
            throw new NoSuchElementException("BST is empty!");
        }
        int ret = getMax();
        root = removeMax(root);
        size--;
        return ret;
    }

    private TreeNode removeMax(TreeNode root) {
        if(root.right == null) {
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public int remove(int val) {
        if(root == null) {
            throw new NoSuchElementException("BST is empty!");
        }
        if(!contains(val)) {
            throw new NoSuchElementException("val is not exists!");
        }
        root = remove(root, val);
        size--;
        return val;
    }

    private TreeNode remove(TreeNode root, int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }
            TreeNode prev = getMax(root.left);
            prev.left = removeMax(root.left);
            prev.right = root.right;
            root = root.left = root.right = null;
            return prev;
        }
        if(val < root.val) {
            root.left = remove(root.left, val);
        }else {
            root.right = remove(root.right, val);
        }
        return root;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generate(root, 0, sb);
        return sb.toString();
    }

    private void generate(TreeNode root, int height, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(generateHeight(height));
        sb.append(root.val).append("\n");
        generate(root.left, height + 1, sb);
        generate(root.right, height + 1, sb);
    }

    private String generateHeight(int height) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}

//public class MyBinSearchTree {
//    private TreeNode root;
//    private int size;
//
//    public MyBinSearchTree() {
//
//    }
//
//    /**
//     * 提供给用户使用的添加方法
//     * @param val 待插入元素
//     */
//    public void add(int val){
//        root = add(root, val);
//    }
//
//    /**
//     * 供内部使用的add方法 - 传入BST的根结点，就能将val插入正确位置，并返回插入后的树根结点
//     * @param root BST的根结点
//     * @param val 待插入元素
//     */
//    private TreeNode add(TreeNode root, int val) {
//        if(root == null){
//            root = new TreeNode(val);
//            size++;
//            return root;
//        }
//        if(val < root.val){
//            root.left = add(root.left, val);
//        }else{
//            root.right = add(root.right, val);
//        }
//        return root;
//    }
//
//    /**
//     * 提供给用户使用的查询方法
//     * @param val
//     * @return
//     */
//    public boolean contains(int val){
//        if(size == 0){
//            throw new NoSuchElementException("BST is empty! cannot search!");
//        }
//        return findVal(root, val) != null;
//    }
//
//    /**
//     * 内部使用的查询方法 - 传入BST的树根结点，就能找到val，并返回该结点
//     * @param root
//     * @param val
//     * @return
//     */
//    private TreeNode findVal(TreeNode root, int val){
//        if(root == null){
//            return null;
//        }
//        if(val == root.val){
//            return root;
//        }else if(val < root.val){
//            return findVal(root.left, val);
//        }else{
//            return findVal(root.right, val);
//        }
//    }
//
//    /**
//     * 找到最小值
//     * @return
//     */
//    public int findMin(){
//        if(size == 0){
//            throw new NoSuchElementException("BST is empty! cannot search!");
//        }
//        return min(root).val;
//    }
//
//    private TreeNode min(TreeNode root){
//        if(root.left == null){
//            return root;
//        }
//        return min(root.left);
//    }
//
//    /**
//     * 找到最大值
//     * @return
//     */
//    public int findMax() {
//        if(size == 0){
//            throw new NoSuchElementException("BST is empty! cannot search!");
//        }
//        return max(root).val;
//    }
//
//    private TreeNode max(TreeNode root){
//        if(root.right == null){
//            return root;
//        }
//        return max(root.right);
//    }
//
//    /**
//     * 删除最小值，并返回被删除元素的值
//     * @return
//     */
//    public int removaMin(){
//        if(size == 0){
//            throw new NoSuchElementException("BST is empty! cannot remove!");
//        }
//        int ret = findMin();
//        root = removeMin(root);
//        return ret;
//    }
//
//    /**
//     * 内部删除最小值，传入树根结点，就能删除该树的最小值，返回删除后的树根结点
//     * @param root
//     * @return
//     */
//    private TreeNode removeMin(TreeNode root){
//        if(root.left == null){
//            //根结点就是待删除元素
//            TreeNode node = root.right;
//            root = root.right = null;
//            return node;
//        }
//        root.left = removeMin(root.left);
//        return root;
//    }
//
//    /**
//     * 删除最大值，返回被删除元素的值
//     * @return
//     */
//    public int removeMax(){
//        int ret = findMax();
//        root = removeMax(root);
//        return ret;
//    }
//
//    /**
//     * 内部删除最大值，传入树根结点，就能删除该树的最大值，返回删除后的树根结点
//     * @param root
//     * @return
//     */
//    private TreeNode removeMax(TreeNode root){
//        if(root.right == null){
//            TreeNode node = root.left;
//            root = root.left = null;
//            return node;
//        }
//        root.right = removeMax(root.right);
//        return root;
//    }
//
//    /**
//     * 供用户使用的删除方法，返回被删除元素的值
//     * @param val
//     * @return
//     */
//    public int remove(int val){
//        if(size == 0){
//            throw new NoSuchElementException("BST is empty! cannot remove!");
//        }
//        TreeNode ret = findVal(root, val);
//        if(ret == null){
//
//        }
//        root = remove(root, val);
//        return ret.val;
//    }
//
//    /**
//     * 传入一颗BST的树根结点，就能删除val，并返回删除后的BST的树根结点
//     * @param root
//     * @param val
//     * @return
//     */
//    private TreeNode remove(TreeNode root, int val) {
//        if(root == null){
//            throw new NoSuchElementException("val does not exists!");
//        }
//        if(val == root.val && root.left == null){
//            //类似于删最小值
//            TreeNode node = root.right;
//            root = root.right = null;
//            return node;
//        }
//        if(val == root.val && root.right == null){
//            //类似于删最大值
//            TreeNode node = root.left;
//            root = root.left = null;
//            return node;
//        }
//        if(val == root.val){
//            TreeNode node = max(root.left);
//            node.left = removeMax(root.left);
//            node.right = root.right;
//            root = root.left = root.right = null;
//            return node;
//        }
//        //当前根结点不是待删除元素
//        if(val < root.val){
//            root.left = remove(root.left, val);
//        }else{
//            root.right = remove(root.right, val);
//        }
//        return root;
//    }
//
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        generateBSTString(root, 0, sb);
//        return sb.toString();
//    }
//
//    /**
//     * 传入BST的树根结点和高度，将BST构建好
//     * @param root
//     * @param height
//     * @param sb
//     */
//    private void generateBSTString(TreeNode root, int height, StringBuilder sb) {
//        if(root == null){
//            sb.append(generateHeight(height)).append("NULL\n");
//            return;
//        }
//        sb.append(generateHeight(height)).append(root.val);
//        sb.append("\n");
//        generateBSTString(root.left, height + 1, sb);
//        generateBSTString(root.right, height + 1, sb);
//    }
//
//    private String generateHeight(int height) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < height; i++) {
//            sb.append("--");
//        }
//        return sb.toString();
//    }
//
//
//}
