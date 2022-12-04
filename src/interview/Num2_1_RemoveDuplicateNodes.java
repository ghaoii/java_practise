package interview;

import java.util.HashSet;
import java.util.Set;

public class Num2_1_RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode node = head.next;
        ListNode prev = head;

        while(node != null) {
            if(set.contains(node.val)) {
                prev.next = node.next;
            }else {
                set.add(node.val);
                prev = prev.next;
            }
            node = node.next;
        }

        return head;
    }
}
