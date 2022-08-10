package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Num567_CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for(char ch : a) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int valid = 0;
        int left = 0;
        int right = 0;
        int len = s1.length();
        while(right < b.length) {
            char ch1 = b[right];
            right++;
            if(need.containsKey(ch1)) {
                window.put(ch1, window.getOrDefault(ch1, 0) +1);
                if(window.get(ch1).equals(need.get(ch1))) {
                    valid++;
                }
            }
            // 窗口大小不超过s1的长度
            while(right - left == len) {
                if(valid == need.size()) {
                    return true;
                }
                char ch2 = b[left];
                if(need.containsKey(ch2)) {
                    if(window.get(ch2).equals(need.get(ch2))) {
                        valid--;
                    }
                    window.put(ch2, window.get(ch2) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
