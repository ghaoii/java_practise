package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length < 3) {
            return ret;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 如果最小的数字都大于0，那么不可能有结果集
            if(nums[i] > 0) {
                return ret;
            }
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }else if(sum > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return ret;
    }
}
