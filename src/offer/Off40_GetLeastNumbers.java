package offer;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Off40_GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) {
            return new int[0];
        }

        int[] ret = new int[k];

        Queue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < arr.length; i++) {
            if(i < k) {
                heap.offer(arr[i]);
            }else if(arr[i] < heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            ret[i] = heap.poll();
        }

        return ret;
    }
}
