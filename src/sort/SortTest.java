package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortTest {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();
    public static void main(String[] args) {
        int n = 10000000;
        //int[] arr = SortHelper.generateSortedArray(n, 10);// 生成一个近乎有序的数组
        int[] arr = SortHelper.generaRandomArray(n, 0, Integer.MAX_VALUE);// 获得一个乱序数组
//        SortHelper.testSort(SortHelper.arrCopy(arr), "bubbleSort");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSort");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "selectionSortOP");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSort");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSort2");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "insertionSortBS");
//        SortHelper.testSort(SortHelper.arrCopy(arr), "shellSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "heapSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "mergeSort");
        SortHelper.testSort(SortHelper.arrCopy(arr), "quickSort");
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    // 双向选择排序，左右两边同时查找
    public static void selectionSortOP(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        while(left <= right) {
            int min = left;
            int max = left;
            for(int i = left + 1; i <= right; i++) {
                if(arr[i] < arr[min]) {
                    min = i;
                }
                if(arr[i] > arr[max]) {
                    max = i;
                }
            }
            swap(arr, left, min);
            if(left == max) {
                max = min;
            }
            swap(arr, right, max);
            left++;
            right--;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i;
            for( ; j > 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }

    public static void insertionSortBS(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int left = 0;
            int right = i;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] < num) {
                    left = mid + 1;
                }else {
                    right = mid;// 找左边界
                }
            }
            for(int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            arr[left] = num;
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length >> 1;
        while(gap >= 1) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int j = i;
                for( ; j >= gap && arr[j - gap] > val; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = val;
            }
            gap >>= 1;
        }
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 先堆化
        int left = (len - 2) / 2;
        for (int i = left; i >= 0; i--) {
            siftDown(arr, i, len);
        }
        for (int i = 0; i < len - 1; i++) {
            swap(arr, 0, len - 1 - i);
            siftDown(arr, 0, len - 1 - i);
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr, 0, arr.length - 1);
    }

    private static void mergeSortInternal(int[] arr, int left, int right) {
        if(right - left <= 15) {
            insertionSort(arr, left, right);
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSortInternal(arr, left, mid);
        mergeSortInternal(arr, mid + 1, right);
        if(arr[mid] <= arr[mid + 1]) {
            return;
        }
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        for (int k = 0; k < aux.length; k++) {
            if(i > mid) {
                aux[k] = arr[j];
                j++;
                continue;
            }
            if(j > right) {
                aux[k] = arr[i];
                i++;
                continue;
            }
            if(arr[i] <= arr[j]) {
                aux[k] = arr[i];
                i++;
            }else {
                aux[k] = arr[j];
                j++;
            }
        }
        for (int k = 0; k < aux.length; k++) {
            arr[k + left] = aux[k];
        }
    }

    public static void quickSort(int[] arr) {
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
        int randomIndex = random.nextInt(left, right + 1);
        swap(arr, left, randomIndex);
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if(arr[i] < arr[left]) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, left, j);
        return j;
    }

    private static int partitionHoare(int[] arr, int left, int right){
        int randomIndex = random.nextInt(left, right + 1);
        swap(arr, left, randomIndex);
        int val = arr[left];
        int i = left;
        int j = right;
        while(i < j) {
            while(i < j && arr[j] >= val) {
                j--;
            }
            swap(arr, i, j);
            while(i < j && arr[i] <= val) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[i] = val;
        return i;
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int val = arr[left];
            int j = i;
            for( ; j > left && arr[j - 1] > val; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
        }
    }

    private static void siftDown(int[] arr, int left, int right) {
        int parent = left;
        while(parent * 2 + 1 < right) {
            int child = parent * 2 + 1;
            if(child + 1 < right && arr[child] < arr[child + 1]) {
                child++;
            }
            if(arr[parent] < arr[child]) {
                swap(arr, parent, child);
                parent = child;
            }else {
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
