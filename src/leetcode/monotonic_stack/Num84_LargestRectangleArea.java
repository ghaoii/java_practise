package leetcode.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num84_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int j = i; j < len; j++) {
                if(stack.isEmpty()) {
                    stack.push(i);
                }else if(heights[j] < heights[stack.peek()]) {
                    stack.pop();
                    stack.push(j);
                }
                int k = stack.peek();
                int area = heights[k] * (j - k + 1);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Num84_LargestRectangleArea test = new Num84_LargestRectangleArea();
        int[] arr = {2,1,5,6,2,3};
        int ret = test.largestRectangleArea(arr);
        System.out.println(ret);
    }
}
