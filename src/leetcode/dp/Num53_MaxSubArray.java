package leetcode.dp;

public class Num53_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, sum);
        }
        return max;
    }

//    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        dp[0] = nums[0];
//        int max = Integer.MIN_VALUE;
//        for (int i = 1; i < len; i++) {
//            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }
}
