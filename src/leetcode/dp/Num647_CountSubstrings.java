package leetcode.dp;

public class Num647_CountSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        int count = 0;
        for(int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1])) {
                    dp[i] = true;
                    count++;
                }else {
                    dp[i] = false;
                }
            }
        }
        return count;
    }

//    public int countSubstrings(String s) {
//        int len = s.length();
//        boolean[][] dp = new boolean[len][len];
//        int count = 0;
//        for(int j = 0; j < len; j++) {
//            for(int i = 0; i <= j; i++) {
//                if(i == j) {
//                    dp[i][j] = true;
//                }else if(s.charAt(j) == s.charAt(i)) {
//                    dp[i][j] = i + 1 == j || dp[i + 1][j - 1];
//                }
//                if(dp[i][j]) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        Num647_CountSubstrings test = new Num647_CountSubstrings();
        String str = "aaa";
        int ret = test.countSubstrings(str);
        System.out.println(ret);
    }
}
