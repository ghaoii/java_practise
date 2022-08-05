package leetcode.dp;

public class Num300_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i] = 1;
//        }
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        int ret = 1;
        for(int i : dp) {
            ret = Math.max(ret, i);
        }
        return ret;
    }
}
