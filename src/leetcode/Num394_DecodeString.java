package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Num394_DecodeString {

    public String decodeString(String s) {
        return decode(1, s);
    }

    private String decode(int n, String subStr) {
        if(n == 0 || subStr == null) {
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subStr.length(); i++) {
            char ch = subStr.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                sb.append(ch);
                continue;
            }
            if(ch >= '0' && ch <= '9') {
                int count = 0;
                while(subStr.charAt(i) >= '0' && subStr.charAt(i) <= '9') {
                    count = count * 10 + subStr.charAt(i) - '0';
                    i++;
                }
                // 此时的i一定指向'['
                stack.push(i);
                int left = i + 1;
                while(!stack.isEmpty()) {
                    i++;
                    if(subStr.charAt(i) == '[') {
                        stack.push(i);
                    }else if(subStr.charAt(i) == ']') {
                        stack.pop();
                    }
                }
                sb.append(decode(count, subStr.substring(left, i)));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ret.append(sb.toString());
        }
        return ret.toString();
    }
}
