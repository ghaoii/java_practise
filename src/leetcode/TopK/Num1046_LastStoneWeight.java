package leetcode.TopK;

import java.util.PriorityQueue;
import java.util.Queue;

public class Num1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while(queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x > y) {
                queue.offer(x - y);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
