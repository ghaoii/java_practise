package leetcode;

public class Num72_MinDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if(word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= col; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // 插入或者删除
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                // 替换
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[row][col];
    }
}
