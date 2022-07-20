package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;// 不重复区间的左区间
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果当前元素已经出现过
            if(map.containsKey(s.charAt(i))) {
                // 如果上个元素不在重复区间内，则不更新
                // 如果上个元素出现在重复区间内，则更新
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 如果没有重复元素，则保存
            // 如果有重复元素，则更新为当前位置
            map.put(s.charAt(i), i);
            // 如果当前不重复子串的长度大于max，则更新
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
