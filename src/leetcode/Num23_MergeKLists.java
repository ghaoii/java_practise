package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Num23_MergeKLists {
    // 最小堆
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode node : lists) {
            if(node != null) {
                heap.offer(node);
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummyHead.next;
    }

    // 暴力求解
//    public ListNode mergeKLists(ListNode[] lists) {
//        int len = lists.length;
//        int[] nodePos = new int[len];
//        ListNode dummyHead = new ListNode();
//        ListNode node = dummyHead;
//        while(true) {
//            boolean flag = true;
//            int min = Integer.MAX_VALUE;
//            int minPos = 0;
//            for (int i = 0; i < len; i++) {
//                if(lists[i] != null && lists[i].val < min) {
//                    flag = false;
//                    min = lists[i].val;
//                    minPos = i;
//                }
//            }
//            if(flag) {
//                break;
//            }
//            node.next = lists[minPos];
//            node = node.next;
//            lists[minPos] = lists[minPos].next;
//        }
//        return dummyHead.next;
//    }
}
