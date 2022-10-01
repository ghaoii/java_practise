package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class Num300_LengthOfLIS {
    // 二分搜索法
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = list.size();

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(list.get(mid) == nums[i]) {
                    right = mid;
                }else if(list.get(mid) < nums[i]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            if(left == list.size()) {
                list.add(nums[i]);
            }else {
                list.set(left, nums[i]);
            }
        }
        return list.size();
    }

//    public int lengthOfLIS(int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len];
//        for (int i = 0; i < len; i++) {
//            dp[i] = 1;
//        }
//        int max = 1;
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if(nums[j] > nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }

//    public int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
////        for (int i = 0; i < dp.length; i++) {
////            dp[i] = 1;
////        }
//        for (int i = 1; i < dp.length; i++) {
//            int max = 0;
//            for (int j = 0; j < i; j++) {
//                if(nums[i] > nums[j]) {
//                    max = Math.max(max, dp[j]);
//                }
//            }
//            dp[i] = max + 1;
//        }
//        int ret = 1;
//        for(int i : dp) {
//            ret = Math.max(ret, i);
//        }
//        return ret;
//    }
}
