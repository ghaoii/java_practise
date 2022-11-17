package offer;

import java.util.HashSet;
import java.util.Set;

public class Off48_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        // 滑动窗口的左右区间
        int left = 0;
        int right = 0;
        // set集合用于保存区间中的元素
        Set<Character> set = new HashSet<>();
        int max = 1;
        while(right < s.length()) {
            char ch = s.charAt(right++);
            // 如果set集合中已经存在当前字符了，就说明left和right之间存在重复字符
            if(set.contains(ch)) {
                // 不断缩小左窗口，直到找到重复的字符
                while(left < right) {
                    // 找到重复元素了，就直接退出
                    if(s.charAt(left) == ch) {
                        left++;
                        break;
                    }
                    // 窗口缩小时，移除未重复元素
                    set.remove(s.charAt(left++));
                }
            }
            // 此时滑动窗口中不存在重复
            set.add(ch);
            // 更新窗口大小
            max = Math.max(max, right - left);
        }
        return max;
    }
}
