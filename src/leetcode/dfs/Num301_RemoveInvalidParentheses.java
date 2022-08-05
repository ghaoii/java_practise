package leetcode.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Num301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        char[] ch = s.toCharArray();
        // 统计需要删除的左右括号
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == '(') {
                left++;
            }else if(ch[i] == ')' && left == 0){
                right++;
            }else {
                left--;
            }
        }
        int bracketNums = ch.length - left - right;
        List<String> ret = new ArrayList<>();
        Deque<StringBuilder> queue = new LinkedList<>();
        queue.offer(new StringBuilder());
        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                StringBuilder sb = queue.poll();
                if(index == ch.length) {
                    if(isValid(sb.toString(), left, right, bracketNums)) {
                        ret.add(sb.toString());
                    }
                    continue;
                }
                if(sb.length() > index - left - right) {
                    queue.offer(sb);
                }
                if(ch[index] == '(') {
                    queue.offer(sb.append(ch[index]));
                }else if(ch[index] == ')') {

                }else {

                }
            }
            index++;
        }
        return ret;
    }

    private boolean isValid(String str, int left, int right, int bracketNums) {
        if(str.length() != bracketNums) {
            return false;
        }
        char[] ch = str.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '(') {
                stack.push(ch[i]);
            }else if(stack.isEmpty()){
                return false;
            }else if(ch[i] == ')'){
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
