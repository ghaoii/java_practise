package leetcode.dp;

import java.util.Arrays;

public class Num322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        for (int i = 1; i <= amount; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < coins.length; j++) {
//                if(i < coins[j] || dp[i - coins[j]] == -1) {
//                    continue;
//                }
//                min = Math.min(min, 1 + dp[i - coins[j]]);
//            }
//            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
//        }
//        return dp[amount];
//    }
}
