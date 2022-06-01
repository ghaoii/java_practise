package bintree.heap.leetcode;

import java.util.*;

class SumNode {
    int u;
    int v;

    public SumNode(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class Num373_KSmallestPairs {
    //找出最小的k对数字，取小用大
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();

        Queue<SumNode> queue = new PriorityQueue<>(new Comparator<SumNode>() {
            @Override
            public int compare(SumNode o1, SumNode o2) {
                return o2.u + o2.v - (o1.u + o1.v);
            }
        });

        for (int i = 0; i < nums1.length && i < k; i++) {
            for (int j = 0; j < nums2.length && j < k; j++) {
                if(queue.size() < k){
                    queue.offer(new SumNode(nums1[i], nums2[j]));
                }else{
                    if(nums1[i] + nums2[j] < queue.peek().u + queue.peek().v){
                        queue.poll();
                        queue.offer(new SumNode(nums1[i], nums2[j]));
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            SumNode node = queue.poll();
            arr.add(node.u);
            arr.add(node.v);
            ret.add(arr);
        }
        return ret;
    }
}
