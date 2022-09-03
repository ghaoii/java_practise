package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Num771_NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for(char ch : jewels.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for(char ch : stones.toCharArray()) {
            if(set.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}
