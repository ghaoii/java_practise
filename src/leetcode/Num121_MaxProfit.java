package leetcode;

public class Num121_MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        // dp(i,j): 处于第i天的j状态时的最大现金
        // j的状态: 0表示不持股，1表示持股
        // 买入股票时，现金会减少，卖出股票时，现金会增加
        int[][] dp = new int[len][2];
        dp[0][0] = 0;// 第一天不持股，没有现金
        dp[0][1] = -prices[0];// 第一天就持股，只能是当天购买的，因此持有现金为当天股票价格的相反数
        for (int i = 1; i < len; i++) {
            // 不持股的两种情况：1.昨天也不持股，今天延续；2.昨天持股，今天卖出
            // 如果今天卖出，那么当天的持有的现金是昨天持股的现金，加上今天卖出的股票价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持股的两种情况：1.昨天也持股，今天延续；2.昨天不持股，今天买入
            // 如果今天买入，那么当前的持有现金是当天股价的相反数，因为只存在一次交易，所以买入只存在一次
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        // 返回最后一天的情况，不需要考虑持股的情况，要么没卖出去，要么最后一天买入
        return dp[len - 1][0];
    }

    // 贪心
//    public int maxProfit(int[] prices) {
//        if(prices == null || prices.length == 1) {
//            return 0;
//        }
//        int max = 0;
//        int minPrice = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if(prices[i] < minPrice) {
//                minPrice = prices[i];
//            }else {
//                max = Math.max(max, prices[i] - minPrice);
//            }
//        }
//        return max;
//    }
}
