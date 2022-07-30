package leetcode;

public class Num152_MaxProduct {
    // 真动归
    public int maxProduct(int[] nums) {
        int iMin = 1;
        int iMax = 1;
        int max = Integer.MIN_VALUE;
        for(int i : nums) {
            if(i < 0) {
                // 如果当前i小于0，下一次乘积会让最大变成最小，最小变成最大
                // 因此提前交换当前最大和最小值
                int temp = iMin;
                iMin = iMax;
                iMax = temp;
            }
            iMin = Math.min(i * iMin, i);
            iMax = Math.max(i * iMax, i);
            max = Math.max(max, iMax);
        }
        return max;
    }


    // 假动归 - 暴力解
//    public int maxProduct(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            if(nums[i] >= 0) {
//                dp[i] = Math.max(nums[i] , nums[i] * dp[i - 1]);
//            }else {
//                int mul = 1;
//                int max = nums[i];
//                for(int j = i - 1; j >= 0; j--) {
//                    mul *= nums[j];
//                    max = Math.max(max, nums[i] * mul);
//                }
//                dp[i] = max;
//            }
//        }
//        int max = -10;
//        for(int i : dp) {
//            max = Math.max(max, i);
//        }
//        return max;
//    }
}
