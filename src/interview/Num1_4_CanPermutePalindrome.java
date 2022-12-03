package interview;

import java.util.HashMap;
import java.util.Map;

public class Num1_4_CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() < 2) {
            return true;
        }

        int[] arr = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;// 记录出现次数为单数的字符

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                count++;
            }
        }

        if(s.length() % 2 == 1) {
            return count == 1;
        }

        return count == 0;
    }
}
