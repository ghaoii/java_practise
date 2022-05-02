package leetcode;

import java.util.List;

public class Num234_Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode middle = Middle(head);
        ListNode newHead = reverse(middle);
        while(newHead != null){
            if(newHead.val != head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    //找中间结点
    public static ListNode Middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //反转链表
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
