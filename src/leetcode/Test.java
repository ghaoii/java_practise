package leetcode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int[] val = {1,1,2,3,3,3};
        ListNode head = test.build(val);
        Num876_MiddleNode middle = new Num876_MiddleNode();
        System.out.println(test.print(middle.middleNode(head)));

    }

    public ListNode build(int[] val){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for(int i : val){
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return dummyHead.next;
    }

    public String print(ListNode head){
        ListNode node = head;
        String ret = "";
        while(node != null){
            ret += node.val;
            ret += "->";
            node = node.next;
        }
        ret += "NULL";
        return ret;
    }

}
