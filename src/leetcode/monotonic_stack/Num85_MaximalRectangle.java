package leetcode.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            max = Math.max(max, maxArea(height));
        }
        return max;
    }

    private int maxArea(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        len += 2;
        newHeights[0] = 1;
        for (int i = 1; i < len - 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int max = 0;
        for (int i = 1; i < len; i++) {
            while(newHeights[i] < newHeights[stack.peek()]) {
                int index = stack.pop();
                int area = newHeights[index] * (i - stack.peek() - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
