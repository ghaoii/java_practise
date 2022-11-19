package offer;

public class Off53_MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(mid == nums[mid]) {
                left = mid + 1;
            }else if(mid < nums[mid]) {
                right = mid;
            }
            // 不可能出现下标mid大于当前数字的情况
        }
        return left;
    }
}
