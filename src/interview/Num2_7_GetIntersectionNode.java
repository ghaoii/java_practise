package interview;

public class Num2_7_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode node1 = headA;
        ListNode node2 = headB;
        boolean flag = false;

        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            if(node1 == null && !flag) {
                node1 = headB;
                flag = true;
            }else if(node1 == null && flag) {
                return null;
            }

            if(node2 == null) {
                node2 = headA;
            }
        }

        return node1;
    }
}
