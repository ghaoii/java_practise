package leetcode;

public class Num198_Rob {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(i <= 1) {
                dp[i] = nums[i];
                continue;
            }
            dp[i] = max + nums[i];
            max = Math.max(max, dp[i - 1]);
        }
        return Math.max(max, dp[nums.length - 1]);
    }
}
