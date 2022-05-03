package linkedlist;

public class DoubleNode {
    DoubleNode prev;
    int val;
    DoubleNode next;

    public DoubleNode(){

    }

    public DoubleNode(int val) {
        this.val = val;
    }

    public DoubleNode(DoubleNode prev, int val, DoubleNode next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}
