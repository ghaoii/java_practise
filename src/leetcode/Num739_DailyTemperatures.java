package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ret = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            ret[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ret;
    }
}
