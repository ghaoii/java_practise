package sort;

import bintree.binsearchtree.TreeNode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class SevenSort {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6,7,8,4,1,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    /**
     * 单向选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * 双向选择排序
     * @param arr
     */
    public static void selectionSortOP(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        //待排序区间[left, right]，已排序区间[0, left), (right, arr.length - 1]
        while(left < right){
            int min = left;
            int max = left;
            for (int i = left + 1; i <= right; i++) {
                if(arr[i] < arr[min]){
                    min = i;
                }
                if(arr[i] > arr[max]) {
                    max = i;
                }
            }
            swap(arr, left, min);
            if(max == left){
                max = min;
            }
            swap(arr, right, max);
            left++;
            right--;
        }
    }

    /**
     * 直接插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = i;
            for( ; j > 0 && val < arr[j - 1]; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = val;
        }
    }

    //更简单的写法，但是效率较低
//    public static void insertionSort(int[] arr){
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
//                swap(arr, j, j - 1);
//            }
//        }
//    }

    public static void insertionSortBS(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int left = 0;
            int right = i - 1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                if(arr[i] < arr[mid]){
                    right = mid - 1;//不加1可以在判断最后一个元素的时候
                }else{
                    left = mid + 1;
                }
            }
            //走完循环之后，left所在的位置就是待插入位置
            for (int j = i; j > left ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[left] = val;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length >> 1;
        while(gap >= 1){
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int j = i;
                for( ; j >= gap && val < arr[j - gap]; j -= gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = val;
            }
            gap = gap >> 1;
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static void megerSort(int[] arr){
        megerSortInternal(arr, 0, arr.length - 1);
    }


    /**
     * 传入待排序数组和排序区间，就能将区间内的子数组排序好
     * @param arr
     * @param l
     * @param r
     */
    private static void megerSortInternal(int[] arr, int l, int r) {
        if(l >= r){
            //当待排序元素只有一个或没有的时候，相当于排序好了，直接返回
            return;
        }
        int mid = l + ((r - l) >> 1);
        megerSortInternal(arr, 0, mid);
        megerSortInternal(arr, mid + 1, r);
        if(arr[mid + 1] < arr[mid]){
            meger(arr, l, mid, r);
        }
    }

    private static void meger(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = arr[i + l];
        }
        int i = 0;
        int j = mid + 1 - l;
        for (int k = l; k <= r; k++) {
            if(i + l > mid){
                arr[k] = aux[j];
                j++;
            }else if(j + l> r){
                arr[k] = aux[i];
                i++;
            }else if(aux[i] < aux[j]){
                arr[k] = aux[i];
                i++;
            }else{
                arr[k] = aux[j];
                j++;
            }
        }
    }

    public static void quickSort(int[] arr){
        quickSortInternal(arr, 0, arr.length - 1);
    }

    private static void quickSortInternal(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int pivot = partition(arr, l, r);
        quickSortInternal(arr, l, pivot - 1);
        quickSortInternal(arr, pivot + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(l, r);
        swap(arr, randomIndex, l);
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(v > arr[i]){
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static int partitionHoare(int[] arr, int l, int r){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(l, r);
        swap(arr, randomIndex, l);
        int val = arr[l];
        int i = l;
        int j = r;
        while(i < j){
            while(i < j && arr[j] >= val){
                j--;
            }
            arr[i] = arr[j];
            while(i < j && arr[i] < val){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = val;
        return j;
    }

    public static void heapSort(int[] arr){
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    private static void siftDown(int[] arr, int i, int length) {
        while(i * 2 + 1 < length){
            int j = i * 2 + 1;
            if(j + 1 < length && arr[j + 1] > arr[j]){
                j++;
            }
            if(arr[i] < arr[j]){
                swap(arr, i, j);
            }else{
                return;
            }
            i = j;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
