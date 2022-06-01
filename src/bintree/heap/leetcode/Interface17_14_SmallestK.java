package bintree.heap.leetcode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Interface17_14_SmallestK {
    //利用分区的思想解决问题
    public int[] smallestK(int[] arr, int k) {
        int[] ret = new int[k];
        if(arr == null || arr.length == 0 || k == 0){
            return ret;
        }
        smallestKInternal(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    /**
     * 传入一个数组，和左右区间，不断分区，将元素放在正确的位置，直到把k个最小元素放到正确位置
     * @param arr
     * @param l
     * @param r
     * @param k
     */
    private void smallestKInternal(int[] arr, int l, int r, int k) {
        if(l > r){
            return;
        }
        int p = partition(arr, l, r);
        if(p > 1){
            smallestKInternal(arr, 0, p - 1, k);
        }
        if(p < k - 1){
            smallestKInternal(arr, p + 1, r, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomIndex = random.nextInt(l, r);
        swap(arr, 0, randomIndex);
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < v){
                swap(arr, i, j + 1);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    //利用优先级队列，取小用大
//    public int[] smallestK(int[] arr, int k) {
//        int[] ret = new int[k];
//        if(arr == null || arr.length == 0 || k == 0){
//            return ret;
//        }
//        //传入比较器，构造最大堆
//        Queue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//
//        for(int i : arr){
//            if(heap.size() < k){
//                //当堆中元素还不足k个的时候，直接将元素添加到堆中
//                heap.offer(i);
//            }else{
//                if(i < heap.peek()){
//                    heap.poll();
//                    heap.offer(i);
//                }
//            }
//        }
//        int i = 0;
//        while(!heap.isEmpty()){
//            ret[i] = heap.poll();
//            i++;
//        }
//        return ret;
//    }
}
