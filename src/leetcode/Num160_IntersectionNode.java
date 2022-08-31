package leetcode;

public class Num160_IntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while(node1 != node2) {
            if(node1 == null) {
                node1 = headB;
            }else {
                node1 = node1.next;
            }

            if(node2 == null) {
                node2 = headA;
            }else {
                node2 = node2.next;
            }
        }
        return node1;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode a = headA;
//        ListNode b = headB;
//        while(a != b){
//            if(a == null){
//                a = headB;
//            }else{
//                a = a.next;
//            }
//            if(b == null){
//                b = headA;
//            }else{
//                b = b.next;
//            }
//        }
//        return a;
//    }
}
