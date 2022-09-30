package leetcode.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num30_FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> need = new HashMap<>();
        for(String str : words) {
            need.put(str, need.getOrDefault(str, 0) + 1);
        }

        int wordLen = words[0].length();
        int tarLen = words.length * wordLen;
        for (int i = 0; i <= s.length() - tarLen; i++) {
            Map<String, Integer> window = new HashMap<>();
            int valid = 0;
            for (int j = i; j < i + tarLen; j += wordLen) {
                String str = s.substring(j, j + wordLen);
                if(need.containsKey(str)) {
                    window.put(str, window.getOrDefault(str, 0) + 1);
                    if(window.get(str).equals(need.get(str))) {
                        valid++;
                    }
                }
            }
            if(valid == need.size()) {
                list.add(i);
            }
        }
        return list;
    }
}
