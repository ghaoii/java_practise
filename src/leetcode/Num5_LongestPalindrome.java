package leetcode;

public class Num5_LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] pal = new boolean[len][len];
        // 初始化
        pal[0][0] = true;
        int max = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j) {
                    pal[i][j] = true;
                }else if(j + 1 == i) {
                    pal[i][j] = s.charAt(j) == s.charAt(i);
                }else {
                    pal[i][j] = s.charAt(j) == s.charAt(i) && pal[i - 1][j + 1];
                }
                if(pal[i][j] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
