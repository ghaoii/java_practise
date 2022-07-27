package linkedlist;

import leetcode.ListNode;

public class DoubleLinkedList {

    DoubleNode head;

    DoubleNode tail;

    int size;

    public boolean addFirst(int val) {
        if(isEmpty()) {
            head = new DoubleNode(val);
            tail = head;
        }else {

        }
        size++;
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        DoubleNode node = head;
        String ret = "";
        while(node != null) {
            ret += node.val;
            if(node.next != null) {
                ret += "->";
            }
            node = node.next;
        }
        return ret;
    }
}
