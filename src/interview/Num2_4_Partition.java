package interview;

public class Num2_4_Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode front = new ListNode(0);
        front.next = head;
        ListNode dummyHead = new ListNode(0);
        ListNode rear = dummyHead;

        ListNode node = head;
        while (node != null) {
            if(node.val < x) {
                front = front.next;
                front.val = node.val;
            }else {
                rear.next = new ListNode(0);
                rear = rear.next;
                rear.val = node.val;
            }
            node = node.next;
        }

        front.next = dummyHead.next;
        return head;
    }
}
