package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num32_LongestValidParentheses {
    // 利用栈解决
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        // 让-1作为上一个不合法的括号的下标(辅助作用)
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else{
                int pos = stack.pop();
                if(stack.isEmpty()) {
                    // 如果把不合法的括号取出来了，说明当前括号也是不合法的
                    stack.push(i);
                    continue;
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    // dp
//    public int longestValidParentheses(String s) {
//        if(s == null || s.length() <= 1) {
//            return 0;
//        }
//        int len = s.length();
//        int[] dp = new int[len];
//        // 初始化: 只有一个括号，不能组合
//        dp[0] = 0;
//        int max = 0;
//        for (int i = 1; i < len; i++) {
//            if(s.charAt(i) == '(') {
//                dp[i] = 0;
//            }else {
//                if(s.charAt(i - 1) == '(') {
//                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
//                }else {
//                    if(i - 1 - dp[i - 1] < 0 || s.charAt(i - 1 - dp[i - 1]) == ')') {
//                        dp[i] = 0;
//                    }else {
//                        dp[i] = dp[i - 1] + 2;
//                        dp[i] +=  i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2]  : 0;
//                    }
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }
}
