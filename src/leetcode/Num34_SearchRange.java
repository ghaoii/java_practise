package leetcode;

import java.util.Arrays;

public class Num34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ret = {-1, -1};
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                int temp = mid;
                while(temp > 0 && nums[temp - 1] == target) {
                    temp--;
                }
                ret[0] = temp;
                temp = mid;
                while(temp < nums.length - 1 && nums[temp + 1] == target) {
                    temp++;
                }
                ret[1] = temp;
                return ret;
            }
        }
        return ret;
    }
}
