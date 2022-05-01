package leetcode;

public class Num203_RemoveElements {
    /**
     * 没有虚拟头结点的解法
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return null;
        }
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;
    }



    /**
     * 递归求解
     * 传入链表的头结点和待删除元素，就能删除链表中所有目标元素，并返回新的头结点
     * @param head
     * @param val
     * @return
     */
//    public ListNode removeElements(ListNode head, int val) {
//        if(head == null){
//            return null;
//        }
//        head.next = removeElements(head.next, val);
//        if(head.val == val){
//            return head.next;
//        }
//        return head;
//    }


    /**
     * 通过虚拟头结点解决
     */
//    public ListNode removeElements(ListNode head, int val) {
//        if(head == null){
//            return null;
//        }
//        ListNode dummyHead = new ListNode();
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//        while(prev.next != null){
//            if(prev.next.val == val){
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }
//        return dummyHead.next;
//    }
}
