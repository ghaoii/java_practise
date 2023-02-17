package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if(nums == null || nums.length < 2) {
            return ret;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(map.containsKey(n)) {
                ret[0] = map.get(n);
                ret[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ret;
    }

    //双循环
//    public int[] twoSum(int[] nums, int target) {
//        int[] ret = new int[2];
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target){
//                    ret[0] = i;
//                    ret[1] = j;
//                    break;
//                }
//            }
//        }
//        return ret;
//    }
}
