package linkedlist;


/**
 * 链表的结点定义
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this(val);
        this.next = next;
    }

}
