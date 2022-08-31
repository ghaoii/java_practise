package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Integer> map1 = new HashMap<>();
        int count = 1;
        String[] words = s.split(" ");
        StringBuilder sb1 = new StringBuilder();
        for(String str : words) {
            if(map1.containsKey(str)) {
                sb1.append(map1.get(str));
            }else {
                sb1.append(count);
                map1.put(str, count);
                count++;
            }
        }

        Map<Character, Integer> map2 = new HashMap<>();
        count = 1;
        StringBuilder sb2 = new StringBuilder();
        for(char ch : pattern.toCharArray()) {
            if(map2.containsKey(ch)) {
                sb2.append(map2.get(ch));
            }else {
                sb2.append(count);
                map2.put(ch, count);
                count++;
            }
        }

        return sb2.toString().equals(sb1.toString());
    }
}
