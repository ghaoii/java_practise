package offer;

public class Off18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if(head.val == val) {
            return head.next;
        }
        ListNode prev = head;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                return head;
            }
            prev = cur;
            cur =cur.next;
        }
        return head;
    }
}
