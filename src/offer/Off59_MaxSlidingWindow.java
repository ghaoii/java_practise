package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Off59_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while(right < nums.length) {
            while(!queue.isEmpty() && nums[right] > queue.peekLast()) {
                queue.pollLast();
            }
            queue.offer(nums[right]);
            right++;

            if(right < k) {
                continue;
            }

            res[index++] = queue.peek();
            if(nums[left] == queue.peek()) {
                queue.poll();
            }
            left++;
        }
        return res;
    }
}
