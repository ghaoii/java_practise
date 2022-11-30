package leetcode.dp;

public class Num45_Jump {
    // 方法2
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int index = i + j;
                if(index >= nums.length) {
                    break;
                }

                if(dp[index] == 0) {
                    dp[index] = dp[i] + 1;
                }else {
                    dp[index] = Math.min(dp[index], dp[i] + 1);
                }
            }
        }

        return dp[nums.length - 1];
    }

    // 方法1
//    public int jump(int[] nums) {
//        if(nums.length == 1) {
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//
//        // base case
//        // dp[0] = 0;
//
//        for (int i = 1; i < nums.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int j = i - 1; j >= 0; j--) {
//                if(i - j <= nums[j]) {
//                    min = Math.min(min, dp[j] + 1);
//                    if(min == 1) {
//                        break;
//                    }
//                }
//            }
//            dp[i] = min;
//        }
//
//        return dp[nums.length - 1];
//    }
}
