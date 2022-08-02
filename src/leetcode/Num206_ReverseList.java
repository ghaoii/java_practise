package leetcode;

public class Num206_ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //递归
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode node = head.next;
//        ListNode newHead = reverseList(head.next);
//        node.next = head;
//        head.next = null;
//        return newHead;
//    }


    //解法二，迭代
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = null;
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }


    //解法一，创建新链表
//    public ListNode reverseList(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode node = head;
//        ListNode newNode = null;
//        while(node != null){
//            newNode = new ListNode(node.val, newNode);
//            node = node.next;
//        }
//        return newNode;
//    }
}
