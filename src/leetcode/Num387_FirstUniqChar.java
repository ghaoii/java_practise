package leetcode;

public class Num387_FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int ret = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 1) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}
