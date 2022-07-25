package linkedlist;

import java.util.NoSuchElementException;

public class LinkedListNoHead {
    ListNode head = null;

    int size;

    /**
     * 在末尾添加元素
     * @param val
     * @return
     */
    public boolean add(int val) {
        if(isEmpty()) {
            head = new ListNode(val);
        }else {
            ListNode node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(val);
        }
        size++;
        return true;
    }

    public void add(int index, int val) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is illegal! cannot add!");
        }
        if(index == 0) {
            addFirst(val);
            return;
        }
        ListNode prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = new ListNode(val, prev.next);
        size++;
    }

    public void addFirst(int val) {
        head = new ListNode(val, head.next);
        size++;
    }

    public int get(int index) {
        if(!indexInRound(index)) {
            throw new IndexOutOfBoundsException("index is illegal! cannot get valur!");
        }
        ListNode ret = head;
        for (int i = 0; i < index; i++) {
            ret = ret.next;
        }
        return ret.val;
    }

    public boolean contains(int val) {
        ListNode node = head;
        while(node != null) {
            if(node.val == val) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 返回链表中最前面的val的下标
     * @param val
     * @return
     */
    public int indexOf(int val) {
        int index = 0;
        ListNode node = head;
        while(node != null) {
            if(node.val == val) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    public int remove(int index) {
        if(!indexInRound(index)) {
            throw new IndexOutOfBoundsException("index is not illegal! cannot remove!");
        }
        if(isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty! cannot remove!");
        }
        int ret = 0;
        if(index == 0) {
            ret = head.val;
            head = head.next;
        }else {
            ListNode prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            ListNode node = prev.next;
            ret = node.val;
            prev.next = node.next;
            node.next = null;
        }
        size--;
        return ret;
    }

    /**
     * 删除立案表中第一个val
     * @param val
     * @return
     */
    public boolean removeByVal(int val) {
        if(isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty! cannot remove!");
        }
        int ret = 0;
        // 单独处理头结点
        if(head.val == val) {
            ret = head.val;
            ListNode node = head;
            head = head.next;
            node.next = null;
            return true;
        }else {
            ListNode prev = head;
            while(prev.next != null) {
                if(prev.next.val == val) {
                    ListNode node = prev.next;
                    ret = node.val;
                    prev.next = node.next;
                    node.next = null;
                    return true;
                }
                prev = prev.next;
            }
        }
        size--;
        return false;
    }

//    public boolean removeByValAll(int val) {
//
//    }

    public String toString() {
        ListNode node = head;
        int index = 0;
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

    private boolean indexInRound(int index) {
        return index >= 0 && index < size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
