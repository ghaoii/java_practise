package leetcode;

public class Num92_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode successor = cur.next;
            cur.next = successor.next;
            successor.next = prev.next;
            prev.next = successor;
        }
        return dummyHead.next;
    }
}
