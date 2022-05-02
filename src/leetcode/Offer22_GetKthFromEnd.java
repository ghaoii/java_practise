package leetcode;

import java.util.List;

public class Offer22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k < 0 ){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null){
            fast = fast.next;
            count++;
            if(count > k){
                slow = slow.next;
            }
        }
        if(count < k){
            return null;
        }
        return slow;
    }
}
