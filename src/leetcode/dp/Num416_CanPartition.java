package leetcode.dp;

public class Num416_CanPartition {
    // dp，转化为0-1背包问题
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(((sum & 1) == 1)) {
            return false;
        }
        int len = nums.length;
        int target = sum / 2;
        // 初始化dp[0][0] = false(其实true也可以，不过不符合状态定义)
        boolean[][] dp = new boolean[len][target + 1];
        if(nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= target; j++) {
                // 相当于j放不进去，只能延续上一行
                dp[i][j] = dp[i - 1][j];
                // 要是放得进去，在进行额外判断
                if(j >= nums[i]) {
                    dp[i][j] = nums[i] == j || dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    // 超时算法
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for(int i : nums) {
//            sum += i;
//        }
//        return dfs(nums, 0, 0, sum);
//    }
//    private boolean dfs(int[] nums, int curPos, int curSum, int allSum) {
//        if(curPos == nums.length - 1) {
//            return false;
//        }
//        for (int i = curPos; i < nums.length - 1; i++) {
//            curSum += nums[i];
//            int dif = allSum - curSum;
//            if(dif == curSum) {
//                return true;
//            }
//            if(curSum < dif && dfs(nums, i + 1, curSum, allSum)) {
//                return true;
//            }
//            curSum -= nums[i];
//        }
//        return false;
//    }
}
