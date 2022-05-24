package bintree;

public class MyBinTreeTest {
    public static void main(String[] args) {
        MyBinTree<Integer> binTree = new MyBinTree<>();
        binTree.build();
        System.out.println("结点个数为：" + binTree.getNodesNonRecursion(binTree.root));
        System.out.println("叶子结点的个数为：" + binTree.getLeafNodesNonRecursion(binTree.root));
        System.out.println("第3层的结点个数为：" + binTree.getKLevelNodeNonRecursion(binTree.root, 3));
        System.out.println("高度为：" + binTree.height(binTree.root));
        System.out.println(binTree.contains(binTree.root, 3));
        System.out.println(binTree.contains(binTree.root, 10));
        binTree.levelOrder(binTree.root);

    }
}
