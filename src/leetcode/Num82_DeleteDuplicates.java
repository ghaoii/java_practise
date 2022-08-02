package leetcode;

import java.util.List;

public class Num82_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next;
            if(next.val == cur.val) {
                while(next != null && next.val == cur.val) {
                    next = next.next;
                }
                prev.next = next;
            }else {
                prev = cur;
            }
            cur = next;
        }
        return dummyHead.next;
    }

    //递归 - 传入一个链表的头结点，就能帮我们删除所有重复元素，返回新的头结点
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = prev.next;
//        if(prev.val == cur.val){
//            while(cur != null && cur.val == prev.val){
//                cur = cur.next;
//            }
//            return deleteDuplicates(cur);
//        }
//        head.next = deleteDuplicates(head.next);
//        return head;
//    }


    //迭代
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        ListNode cur = prev.next;
//        while(cur != null && cur.next != null){
//            ListNode next = cur.next;
//            if(cur.val == next.val){
//                while(next != null && cur.val == next.val){
//                    next = next.next;
//                }
//                prev.next = next;
//                cur = next;
//            }else{
//                prev = prev.next;
//                cur = cur.next;
//            }
//        }
//        return dummyHead.next;
//    }
}
