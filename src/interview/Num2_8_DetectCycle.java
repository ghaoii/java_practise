package interview;

public class Num2_8_DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode fir = head;
        ListNode sec = head;

        while(fir != null && fir.next != null) {
            fir = fir.next.next;
            sec = sec.next;
            if(fir == sec) {
                break;
            }
        }

        if(fir == null || fir.next == null) {
            return null;
        }

        fir = head;
        while(fir != sec) {
            fir = fir.next;
            sec = sec.next;
        }

        return fir;
    }
}
