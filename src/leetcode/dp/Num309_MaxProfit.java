package leetcode.dp;

public class Num309_MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 状态f(i,0):第i天不持有股票且不是今天卖出
        // 状态f(i,1):第i天持有股票，要么是昨天延续的，要么是今天买的，对于后者，昨天一定不持有股票且没有卖出
        // 状态f(i,2):第i天不持有股票，不过是今天卖出的，那么昨天一定持有股票
        int[][] dp = new int[len][3];
        dp[0][0] = 0;// 第一天不买
        dp[0][1] = -prices[0];// 第一天只买入
        dp[0][2] = 0;// 相当于买了又卖出去了
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
