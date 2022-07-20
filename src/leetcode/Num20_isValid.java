package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Num20_isValid {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < ch.length; i++) {
            // 左括号直接入栈
            if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                stack.push(ch[i]);
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            char bracket = stack.pop();
            if(ch[i] == ')' && bracket != '(') {
                return false;
            }
            if(ch[i] == ']' && bracket != '[') {
                return false;
            }
            if(ch[i] == '}' && bracket != '{') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
