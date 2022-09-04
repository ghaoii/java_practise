package offer;

public class Off51_ReversePairs {
    public int reversePairs(int[] nums) {
        return Internal(nums, 0, nums.length - 1);
    }

    private int Internal(int[] arr, int left, int right) {
        if(left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = Internal(arr, left, mid) + Internal(arr, mid + 1, right);
        if(arr[mid] <= arr[mid + 1]) {
            return count;
        }
        return count + merge(arr, left, mid, right);
    }

    private int merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arr[i + left];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if(i > mid) {
                arr[k] = aux[j - left];
                j++;
            }else if(j > right) {
                arr[k] = aux[i - left];
                i++;
            }else if(aux[i - left] <= aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            }else {
                arr[k] = aux[j - left];
                count += mid - i + 1;
                j++;
            }
        }
        return count;
    }
}
