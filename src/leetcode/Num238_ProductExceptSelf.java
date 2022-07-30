package leetcode;

import java.util.*;

public class Num238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        ret[0] = 1;
        for (int i = 1; i < len; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = len - 2; i >= 0; i--) {
            r *= nums[i + 1];
            ret[i] *= r;
        }
        return ret;
    }


//    public int[] productExceptSelf(int[] nums) {
//        int[] left = new int[nums.length];
//        int[] right = new int[nums.length];
//        left[0] = 1;
//        right[nums.length - 1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            left[i] = left[i - 1] * nums[i - 1];
//            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            left[i] *= right[i];
//        }
//        return left;
//    }
}
