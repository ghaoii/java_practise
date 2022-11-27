package offer;

import java.util.LinkedList;
import java.util.List;

public class Off58_ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        int start = s.length() - 1;
        int end = s.length();
        StringBuilder sb = new StringBuilder();
        while(start >= 0) {
            char c = s.charAt(start);
            if(c == ' ') {
                sb.append(s, start + 1, end).append(" ");
                while(start > 0 && s.charAt(start - 1) == ' ') {
                    start--;
                }
                end = start;
            }
            start--;
        }
        sb.append(s, 0, end);
        return sb.toString();
    }
}
