package leetcode.dp;

public class Num309_MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        // 第一天不持有股票
        dp[0][0] = 0;
        // 第一天持有股票
        dp[0][1] = prices[0];
        // 第一天因为卖出股票而不持有股票(相当于当天买当天卖)
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            // 不持股且今天没有卖出，那一定是前一天也不持有
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 持股，要么是昨天延续的，要么今天买的，如果是今天买的，昨天一定是不持股的
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 不持股且今天卖出，一定是昨天持股
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
