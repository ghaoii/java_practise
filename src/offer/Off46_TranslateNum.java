package offer;

public class Off46_TranslateNum {
    public int translateNum(int num) {
        if(num == 0) {
            return 1;
        }
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char ch = s.charAt(i - 1);
            dp[i] = dp[i - 1];
            if(i - 2 < 0 || s.charAt(i - 2) == '0') {
                continue;
            }
            if(s.charAt(i - 2) == '1') {
                dp[i] += dp[i - 2];
            }else if(s.charAt(i - 2) == '2' && ch >= '0' && ch <= '5') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
