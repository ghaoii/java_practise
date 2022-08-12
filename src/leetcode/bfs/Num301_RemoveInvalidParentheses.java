package leetcode.bfs;

import java.util.*;

public class Num301_RemoveInvalidParentheses {
    int maxScore;
    int maxLen;
    String str;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        str = s;
        int left = 0;
        int right = 0;
        for(char ch : str.toCharArray()){
            if(ch == '(') {
                left++;
            }else if(ch == ')') {
                if(left == 0) {
                    right++;
                }else {
                    left--;
                }
            }
        }
        maxLen = s.length() - left - right;
        int left2 = 0;
        int right2 = 0;
        for(char ch : str.toCharArray()){
            if(ch == '(') {
                left2++;
            }else if(ch == ')') {
                right2++;
            }
        }
        maxScore = Math.min(left2, right2);
        dfs(0, "", left, right, 0);
        return new ArrayList<>(set);
    }

    private void dfs(int curPos, String curStr, int left, int right, int score) {
        if(left < 0 || right < 0 || score < 0 || score > maxScore) {
            return;
        }
        if(left == 0 && right == 0) {
            if(curStr.length() == maxLen) {
                set.add(curStr);
            }
        }
        if(curPos == str.length()) {
            return;
        }
        char ch = str.charAt(curPos);
        if(ch == '(') {
            dfs(curPos + 1, curStr + ch, left, right, score + 1);
            dfs(curPos + 1, curStr, left - 1, right, score);
        }else if(ch == ')') {
            dfs(curPos + 1, curStr + ch, left, right, score - 1);
            dfs(curPos + 1, curStr, left, right - 1, score);
        }else {
            dfs(curPos + 1, curStr + ch, left, right, score);
        }
    }

    public static void main(String[] args) {
        String str = ")(";
        Num301_RemoveInvalidParentheses test = new Num301_RemoveInvalidParentheses();
        List<String> ret = test.removeInvalidParentheses(str);
    }
}

// 自己写的bfs
//public class Num301_RemoveInvalidParentheses {
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> ret = new LinkedList<>();
//        if(!s.contains("(") && !s.contains(")")) {
//            ret.add(s);
//            return ret;
//        }
//        Deque<String> queue = new ArrayDeque<>();
//        Set<String> set = new HashSet<>();
//        queue.offer(s);
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String str = queue.poll();
//                if(isValid(str)) {
//                    ret.add(str);
//                }
//                for (int j = 0; j < str.length(); j++) {
//                    if(str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
//                        continue;
//                    }
//                    StringBuilder sb = new StringBuilder(str);
//                    String delStr = sb.delete(j, j + 1).toString();
//                    if(!set.contains(delStr)) {
//                        set.add(delStr);
//                        queue.offer(delStr);
//                    }
//                }
//            }
//            if(!ret.isEmpty()) {
//                return ret;
//            }
//        }
//        return ret;
//    }
//
//    private boolean isValid(String str) {
//        if(str == null || str.length() == 0) {
//            return true;
//        }
//        char[] ch = str.toCharArray();
//        Deque<Character> stack = new ArrayDeque<>();
//        for (int i = 0; i < str.length(); i++) {
//            if(ch[i] == '(') {
//                stack.push('(');
//            }else if(ch[i] == ')'){
//                if(stack.isEmpty()) {
//                    return false;
//                }else {
//                    stack.pop();
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//}
