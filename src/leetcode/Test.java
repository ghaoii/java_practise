package leetcode;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Num96_NumTrees test = new Num96_NumTrees();
        System.out.println(test.numTrees(3));;
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
