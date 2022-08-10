package leetcode.sliding_window;

import java.util.*;

public class Num438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new LinkedList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] a = s.toCharArray();
        char[] b = p.toCharArray();
        for(char ch : b) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int valid = 0;
        int left = 0;
        int right = 0;
        int len = b.length;
        while(right < a.length) {
            char ch1 = a[right];
            if(need.containsKey(ch1)) {
                window.put(ch1, window.getOrDefault(ch1, 0) + 1);
                if(window.get(ch1).equals(need.get(ch1))) {
                    valid++;
                }
            }

            right++;
            // 当区间长度等于p的长度的时候，就可可以缩了
            while(right-left == b.length) {
                if(valid == need.size()) {
                    ret.add(left);
                }
                char ch2 = a[left];
                if(need.containsKey(ch2)) {
                    if(window.get(ch2).equals(need.get(ch2))) {
                        valid--;
                    }
                    window.put(ch2, window.get(ch2) - 1);
                }
                left++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Num438_FindAnagrams test = new Num438_FindAnagrams();
        String str1 = "cbaebabacd";
        String str2 = "abc";
        List<Integer> ret = test.findAnagrams(str1, str2);
    }
}
