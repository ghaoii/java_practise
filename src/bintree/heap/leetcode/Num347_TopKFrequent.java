package bintree.heap.leetcode;

import java.util.*;



public class Num347_TopKFrequent {

    static class Node {
        int val;
        int freq;

        public Node(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ret = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.freq - o2.freq));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(queue.size() < k) {
                queue.offer(new Node(entry.getKey(), entry.getValue()));
            }else {
                if(entry.getValue() > queue.peek().freq) {
                    queue.poll();
                    queue.offer(new Node(entry.getKey(), entry.getValue()));
                }
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            ret[i] = queue.poll().val;
            i++;
        }
        return ret;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        int[] ret = new int[k];
//        if(nums == null || nums.length == 0 || k <= 0){
//            return ret;
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//
//        Queue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.freq - o2.freq;
//            }
//        });
//
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(heap.size() < k){
//                heap.offer(new Node(entry.getKey(), entry.getValue()));
//            }else{
//                if(entry.getValue() > heap.peek().freq){
//                    heap.poll();
//                    heap.offer(new Node(entry.getKey(), entry.getValue()));
//                }
//            }
//        }
//        int i = 0;
//        while(!heap.isEmpty()){
//            ret[i++] = heap.poll().val;
//        }
//        return ret;
//    }
}
