package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MonotonousQueue {
    private Deque<Integer> deque;

    public MonotonousQueue() {
        deque = new LinkedList<>();
    }

    /**
     * 插入时，删除deque中比val小的元素，让deque整体递减，队首元素始终为区间内的最大值
     * @param val
     */
    public void push(int val) {
        while(!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }
        deque.offerLast(val);
    }

    /**
     * 如果deque的队首元素等于待删除元素val才删除，否则不删除
     * @param val
     */
    public void poll(int val) {
        if(!deque.isEmpty() && deque.peekFirst() == val) {
            deque.pollFirst();
        }
    }

    public int getMax() {
        return deque.peekFirst();
    }
}

public class Num239_MaxSlidingWindow {
    // 单调队列，直接在方法中实现核心操作
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        ret[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if(nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            ret[i - k + 1] = deque.peekFirst();
        }
        return ret;
    }

    // 单调队列 - 用自己写的数据结构
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        MonotonousQueue window = new MonotonousQueue();
//        int[] ret = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length; i++) {
//            if(i < k - 1) {
//                window.push(nums[i]);
//                continue;
//            }
//            window.push(nums[i]);
//            ret[i - k + 1] = window.getMax();
//            window.poll(nums[i - k + 1]);
//        }
//        return ret;
//    }
}
