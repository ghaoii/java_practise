package bintree.binsearchtree;

public class MyBinSearchTreeTest {
    public static void main(String[] args) {
        MyBinSearchTree bst = new MyBinSearchTree();
        bst.add(22);
        bst.add(15);
        bst.add(28);
        bst.add(11);
        bst.add(17);
        bst.add(25);
        bst.add(31);
        bst.add(9);
        bst.add(23);
        bst.add(27);
        bst.add(30);
        bst.add(40);
        System.out.println(bst.remove(28));
        System.out.println(bst);
//        System.out.println(bst.remove(28));
    }
}
