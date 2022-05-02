package leetcode;

public class Num86_Partition {
    //迭代
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode list1Tail = list1;
        ListNode list2Tail = list2;
        while(head != null){
            if(head.val < x){
                list1Tail.next = head;
                list1Tail = list1Tail.next;
            }else{
                list2Tail.next = head;
                list2Tail = list2Tail.next;
            }
            head = head.next;
        }
        list1Tail.next = list2.next;
        list2Tail.next = null;
        return list1.next;
    }
}
