package leetcode;

public class Num33_Search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        if(target == nums[0]) {
            return 0;
        }
        // 旋转后的数组分为两部分，左边部分任意元素大于右边部分的任意元素
        int left = 0;
        int right = nums.length - 1;
        if(target > nums[0]) {
            // 说明target在左侧
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(nums[mid] >= nums[0]) {
                    // 说明当前mid在左侧，继续比较target和mid处的值
                    if(nums[mid] > target) {
                        // 说明target在mid的左侧
                        right = mid - 1;
                    }else {
                        // 否则target在mid的右侧
                        left = mid + 1;
                    }
                }else {
                    // 说明当前mid在右侧
                    right = mid - 1;
                }
            }
        }else {
            // 说明target在右侧
            while(left <= right) {
                int mid = left + (right - left) / 2;
                if(nums[mid] == target) {
                    // 如果找到了，就返回下标
                    return mid;
                }
                if(nums[mid] < nums[0]) {
                    // 说明mid在右侧，继续比较target和mid处的值
                    if(nums[mid] > target) {
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }else {
                    // mid在左侧
                    left = mid + 1;
                }
            }
        }
        // 走到这里要是没找到，就不存在了
        return -1;
    }
}
