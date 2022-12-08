package interview;

public class Num2_3_DeleteNode {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            node = null;
            return;
        }

        while(node.next != null) {
            ListNode next = node.next;
            node.val = next.val;

            if(next.next == null) {
                node.next = null;
            }else {
                node = next;
            }
        }
    }
}
