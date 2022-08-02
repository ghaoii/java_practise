package leetcode;

public class Num876_MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fir = head;
        ListNode sec = head;
        while(fir != null && fir.next != null) {
            fir = fir.next.next;
            sec = sec.next;
        }
        return sec;
    }

//    public ListNode middleNode(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while(fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
}
