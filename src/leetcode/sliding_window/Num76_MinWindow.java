package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Num76_MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int len = s.length();
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (right < len) {
            char in = s.charAt(right);
            // 如果该元素是目标元素之一，那么加入到window中
            if(need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
                if(window.get(in).equals(need.get(in)))
                    valid++;
            }
            right++;

            // 如果当前窗口中的子串满足要求了，则从从left缩小窗口
            while(valid == need.size()) {
                // 先判断本次的子串长度是否为最小的，如果是的话更新结果
                if(right - left < end - start) {
                    start = left;
                    end = right;
                }
                char out = s.charAt(left);
                // 如果出窗口的元素是目标元素之一
                if(need.containsKey(out)) {
                    if(window.get(out).equals(need.get(out)))
                        valid--;
                    window.put(out, window.get(out) - 1);
                }
                left++;
            }
        }
        // 如果end没变，说明没有符合的答案，返回空字符串
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

//    public String minWindow(String s, String t) {
//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
//        char[] chars = s.toCharArray();
//        char[] target = t.toCharArray();
//       for(char ch : target) {
//           need.put(ch, need.getOrDefault(ch, 0) + 1);
//       }
//        int valid = 0;
//        int left = 0;
//        int right = 0;
//        int start = 0;
//        int len = Integer.MAX_VALUE;
//        while(right < s.length()) {
//            char ch1 = chars[right];
//            if(need.containsKey(ch1)) {
//                window.put(ch1, window.getOrDefault(ch1, 0) + 1);
//                if(need.get(ch1).equals(window.get(ch1))) {
//                    valid++;
//                }
//            }
//            right++;
//            while(valid == need.size()) {
//                // 由于right是开区间，所以right-left就是区间长度
//                if(right - left < len) {
//                    start = left;
//                    len = right - left;
//                }
//                char ch2 = chars[left];
//                if(need.containsKey(ch2)) {
//                    if(window.get(ch2).equals(need.get(ch2))) {
//                        valid--;
//                    }
//                    window.put(chars[left], window.get(chars[left]) - 1);
//                }
//                left++;
//            }
//        }
//        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
//    }
}
