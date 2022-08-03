package leetcode.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num279_NumSquares {
    public int numSquares(int n) {
        if(isComplete(n)) {
            return 1;
        }
        Deque<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int[] book = new int[n + 1];
        for(int i = 1; i < n; i++) {
            if(isComplete(i)) {
                queue.offer(i);
                list.add(i);
                book[i] = 1;
            }
        }
        int height = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for(int i = 0; i < size; i++) {
                int num = queue.poll();
                for(int val : list) {
                    int sum = num + val;
                    if(sum == n) {
                        return height + 1;
                    }
                    if(sum < n && book[sum] == 0) {
                        queue.offer(sum);
                        book[sum] = 1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean isComplete(int val) {
        int temp = (int)Math.sqrt(val);
        return temp * temp == val;
    }
}
