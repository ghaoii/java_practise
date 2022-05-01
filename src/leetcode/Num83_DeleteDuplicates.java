package leetcode;

public class Num83_DeleteDuplicates {
    //解法三,递归
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            return head.next;
        }
        return head;
    }

    //解法二
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = prev.next;
//        while(cur != null){
//            if(prev.val != cur.val){
//                cur = cur.next;
//                prev = prev.next;
//            }else{
//                prev.next = cur.next;
//                cur = cur.next;
//            }
//        }
//        return head;
//    }


    //解法一
//    public ListNode deleteDuplicates(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = head.next;
//        while(cur != null){
//            while(cur != null && cur.val == prev.val){
//                cur = cur.next;
//            }
//            prev.next = cur;
//            prev = cur;
//
//        }
//        return head;
//    }
}
