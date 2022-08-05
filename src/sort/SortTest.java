package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6,7,8,4,1,9};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    private static void quickSort(int[] arr) {
        quickSortInternal(arr, 0, arr.length - 1);
    }

    private static void quickSortInternal(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = partitionHoare(arr, left, right);
        quickSortInternal(arr, left, pivot - 1);
        quickSortInternal(arr, pivot + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(left, right + 1);
        swap(arr, left, randomIndex);
        int val = arr[left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if(arr[j] < val) {
                swap(arr, i + 1, j);
                i++;
            }
        }
        swap(arr, left, i);
        return i;
    }

    private static int partitionHoare(int[] arr, int left, int right) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(left, right + 1);
        swap(arr, left, randomIndex);
        int val = arr[left];
        while(left < right) {
            while(left < right && arr[right] > val) {
                right--;
            }
            arr[left] = arr[right];

            while(left < right && arr[left] < val) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = val;
        return left;
    }

    // 归并排序
    private static void mergeSort(int[] arr) {
        mergeSortInternal(arr, 0, arr.length - 1);
    }

    private static void mergeSortInternal(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortInternal(arr, left, mid);
        mergeSortInternal(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arr[i + left];
        }
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if(i > mid) {
                arr[k] = aux[j - left];
                j++;
            }else if(j > right) {
                arr[k] = aux[i - left];
                i++;
            }else if(aux[i - left] < aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            }else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }


    // 原地堆排序
    private static void heapSort(int[] arr) {
        // 堆化构建最大堆
        for (int i = (arr.length - 2) >> 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }
        // 堆排序
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static void siftDown(int[] arr, int parent, int length) {
        while(parent * 2 + 1 < length) {
            int child = parent * 2 + 1;
            if(child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }
            if(arr[parent] >= arr[child]) {
                return;
            }
            swap(arr, parent, child);
            parent = child;
        }
    }

    // 希尔排序
    private static void ShellSort(int[] arr) {
        int gird = arr.length >> 1;
        while(gird > 0) {
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                int j = i;
                for( ; j >= gird && val < arr[j - gird]; j -= gird) {
                    arr[j] = arr[j - gird];
                }
                arr[j] = val;
            }
            gird = gird >> 1;
        }
    }

    // 二分插入排序
    private static void insertionSortBS(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i] >= arr[i - 1]) {
                continue;
            }
            int left = 0;
            int right = i - 1;
            while(left <= right) {
                int mid = left + ((right - left) >> 1);
                if(arr[i] > mid) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            int val = arr[i];
            for(int j = i; j > right; j--) {
                arr[j] = arr[j - 1];
            }
            arr[right] = val;
        }
    }

    // 插入排序
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int j = i;
            int val = arr[i];
            for( ; j > 0 && val < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
        }
    }

    // 双向选择排序
    private static void selectionSortOP(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int min = left;
            int max = left;
            for(int i = left; i <= right; i++) {
                if(arr[i] < arr[min]) {
                    min = i;
                }
                if(arr[i] > arr[max]) {
                    max = i;
                }
            }
            swap(arr, left, min);
            if(max == left) {
                max = min;
            }
            swap(arr, right, max);
            left++;
            right--;
        }
    }

    // 选择排序
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }


    // 冒泡排序
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
