package jcl.leetcode;

public class Nul387_FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        //遍历数组，统计s中每个字母出现过的次数
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        //再次遍历数组，返回第一个只出现了一次的数字
        for (int i = 0; i < s.length(); i++) {
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
