package leetcode;

import java.util.concurrent.ThreadLocalRandom;

public class Num75_SortColors {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = quickSortInternal(arr, left, right);
        quickSortInternal(arr, left, pivot - 1);
        quickSortInternal(arr, pivot + 1, right);
    }

    private int quickSortInternal(int[] arr, int left, int right) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(left, right);
        swap(arr, left, index);
        int val = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= val) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= val) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = val;
        return left;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
