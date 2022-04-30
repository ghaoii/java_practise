package linkedlist;


/**
 * 链表的结点定义
 */
public class Node {
    int val;
    Node next;

    public Node(){}

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node next){
        this(val);
        this.next = next;
    }

}
