package offer;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class Off36_TreeToDoublyList {
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }

        Node head = helper(root);
        Node node = head;
        while(node.right != null) {
            node = node.right;
        }
        head.left = node;
        node.right = head;
        return head;
    }

    public Node helper(Node root) {
        if(root == null) {
            return null;
        }

        // 将左子树转化为链表，并得到左链表的头结点
        Node leftHead = helper(root.left);
        // 得到左链表的尾结点
        Node leftTail = leftHead;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        // 将左链表和当前结点连接
        if(leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }

        // 将右子树转化为链表，并得到右链表的头结点
        Node rightHead = helper(root.right);
        if(rightHead != null) {
            rightHead.left = root;
            root.right = rightHead;
        }

        return leftHead == null ? root : leftHead;
    }
}
