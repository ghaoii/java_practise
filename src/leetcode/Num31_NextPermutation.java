package leetcode;

import java.util.Arrays;

public class Num31_NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int i = len - 2;
        int j = len - 1;
        while(i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 如果整个数组都是降序的，那就对整个数组进行逆序
        if(i == -1) {
            reverse(nums, 0, len - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }
        // 否则，在降序区间[j, len)中，从后往前找第一个大于nums[i]的元素
        int k = len - 1;
        while(k > i && nums[k] <= nums[i]) {
            k--;
        }
        // 交换nums[i]和nums[k]，交换后[j,len)依然是降序
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
        // 然后逆置降序区域[j,end)
        reverse(nums, j, len - 1);
        // 打印
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
