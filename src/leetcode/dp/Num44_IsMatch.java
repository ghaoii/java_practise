package leetcode.dp;

public class Num44_IsMatch {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if(p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i <= p.length(); i++) {
            char a = p.charAt(i - 1);
            for (int j = 1; j <= s.length(); j++) {
                char b = s.charAt(j - 1);
                if(a == b || a == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(a == '*') {
                    // 不匹配、匹配1次，匹配多次
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }

        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        Num44_IsMatch test = new Num44_IsMatch();
        String s = "adceb";
        String p = "*a*b";
        test.isMatch(s, p);
    }

    // 递归超时
//    private boolean helper(String s, String p, int i, int j) {
//        if(j == p.length()) {
//            return i == s.length();
//        }
//
//        if(i == s.length()) {
//            while(j < p.length()) {
//                if(p.charAt(j++) != '*') {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
//            return helper(s, p, i + 1, j + 1);
//        }else {
//            if(p.charAt(j) == '*') {
//                // 可以匹配，也可以不匹配
//                return helper(s, p, i + 1, j) || helper(s, p, i, j + 1);
//            }
//            return false;
//        }
//    }
}
