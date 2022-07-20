package leetcode;

public class Num19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        int i = 0;
        while(fast != null) {
            fast = fast.next;
            i++;
            if(i > n) {
                prev = slow;
                slow = slow.next;
            }
        }
        if(i < n) {
            return head;
        }
        if(i == n) {
            return head.next;
        }
        prev.next = slow.next;
        return head;
    }
}
