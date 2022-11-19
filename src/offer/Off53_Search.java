package offer;

public class Off53_Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // 找左边界
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(left == nums.length || nums[left] != target) {
            return 0;
        }
        int start = left;

        // 找右边界
        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right - start + 1;
    }
}
