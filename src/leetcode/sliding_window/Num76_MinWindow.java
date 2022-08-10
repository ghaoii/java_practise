package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Num76_MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] target = t.toCharArray();
       for(char ch : target) {
           need.put(ch, need.getOrDefault(ch, 0) + 1);
       }
        int valid = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(right < s.length()) {
            char ch1 = chars[right];
            if(need.containsKey(ch1)) {
                window.put(ch1, window.getOrDefault(ch1, 0) + 1);
                if(need.get(ch1).equals(window.get(ch1))) {
                    valid++;
                }
            }
            right++;
            while(valid == need.size()) {
                // 由于right是开区间，所以right-left就是区间长度
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                char ch2 = chars[left];
                if(need.containsKey(ch2)) {
                    if(window.get(ch2).equals(need.get(ch2))) {
                        valid--;
                    }
                    window.put(chars[left], window.get(chars[left]) - 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
