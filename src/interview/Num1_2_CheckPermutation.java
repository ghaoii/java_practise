package interview;

import java.util.HashMap;
import java.util.Map;

public class Num1_2_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        for(int x : arr) {
            if(x != 0) {
                return false;
            }
        }

        return true;
    }
}
