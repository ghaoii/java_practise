package leetcode.dp;

import java.util.LinkedList;
import java.util.List;

public class Num312_MaxCoins {
    // dp
    public int maxCoins(int[] nums) {
        int[] prices = new int[nums.length + 2];
        prices[0] = 1;
        prices[prices.length - 1] = 1;
        for (int i = 1; i < prices.length - 1; i++) {
            prices[i] = nums[i - 1];
        }
        // 状态f(i,j): 开区间(i,j)所能获得的最大收益
        int[][] dp = new int[prices.length][prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i + 2; j < prices.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + prices[i] * prices[k] * prices[j]);
                }
            }
        }
        return dp[0][prices.length - 1];
    }

    // dfs(时间复杂度太高了)
//    int max = 0;
//    public int maxCoins(int[] nums) {
//        List<Integer> list = new LinkedList<>();
//        for(int i : nums) {
//            list.add(i);
//        }
//        dfs(list, 0, list.size() - 1, 0);
//        return max;
//    }
//
//    private void dfs(List<Integer> list, int curPos, int maxIndex, int sum) {
//        if(curPos > maxIndex) {
//            max = Math.max(max, sum);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            int left = i - 1 < 0 ? 1 : list.get(i - 1);
//            int cur = list.get(i);
//            int right = i + 1 >= list.size() ? 1 : list.get(i + 1);
//            int mul = left * cur * right;
//            sum += mul;
//            list.remove(i);
//            dfs(list, curPos + 1, maxIndex, sum);
//            list.add(i, cur);
//            sum -= mul;
//        }
//    }
}
