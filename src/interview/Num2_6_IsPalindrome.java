package interview;

public class Num2_6_IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode midNode = getMidNode(head);
        ListNode newHead = reverse(midNode);

        while (newHead != null) {
            if(head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode rear = node.next;
            node.next = prev;
            prev = node;
            node = rear;
        }
        return prev;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

