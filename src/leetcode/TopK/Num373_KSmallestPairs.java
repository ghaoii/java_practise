package leetcode.TopK;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Num373_KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.x + o2.y - (o1.x + o1.y);
            }
        });

        int count = 0;
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if(count < k) {
                    queue.offer(new Pair(nums1[i], nums2[j]));
                    count++;
                }else {
                    Pair pair = queue.peek();
                    int sum = pair.x + pair.y;
                    if (nums1[i] + nums2[j] < sum) {
                        queue.poll();
                        queue.offer(new Pair(nums1[i], nums2[j]));
                    }
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            Pair pair = queue.poll();
            list.add(pair.x);
            list.add(pair.y);
            ret.add(list);
        }
        return ret;
    }
}
