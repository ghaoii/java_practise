package offer;

import java.util.*;

public class Off6_ReversePrint {
    List<Integer> list = new LinkedList<>();
    public int[] reversePrint(ListNode head) {
        helper(head);
        int len = list.size();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private void helper(ListNode node) {
        if(node == null) {
            return;
        }
        helper(node.next);
        list.add(node.val);
    }

//    public int[] reversePrint(ListNode head) {
//        int count = 0;
//        Deque<Integer> stack = new ArrayDeque<>();
//        while(head != null){
//            stack.push(head.val);
//            head = head.next;
//            count++;
//        }
//        int[] arr = new int[count];
//        for (int i = 0; i < count; i++) {
//            arr[i] = stack.pop();
//        }
//        return arr;
//    }
}
