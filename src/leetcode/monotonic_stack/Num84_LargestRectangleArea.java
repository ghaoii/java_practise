package leetcode.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num84_LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] arr = new int[len + 2];
        arr[0] = 0;
        for (int i = 0; i < len; i++) {
            arr[i + 1] = heights[i];
        }
        len += 2;
        arr[len - 1] = 0;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while(arr[i] < arr[stack.peek()]) {
                int height = stack.pop();
                int area = arr[height] * (i - stack.peek() - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
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
