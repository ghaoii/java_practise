package interview;

public class Num2_5_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = l1;
        ListNode prev = dummyHead;
        int add = 0;
        while(node1 != null || node2 != null) {
            if(node1 == null) {
                node1 = new ListNode(node2.val + add);
                prev.next = node1;
                node2 = node2.next;
            }else if(node2 == null) {
                node1.val += add;
            }else {
                node1.val += node2.val + add;
                node2 = node2.next;
            }
            add = node1.val / 10;
            node1.val %= 10;
            prev = node1;
            node1 = node1.next;
        }

        if(add > 0) {
            prev.next = new ListNode(add);
        }
        return l1;
    }
}
