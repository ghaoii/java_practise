package leetcode;

import java.util.*;

public class Num406_ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new LinkedList<>();
        for(int[] peo : people) {
            list.add(peo[1], peo);
        }
        for (int i = 0; i < people.length; i++) {
            people[i] = list.get(i);
        }
        return people;
    }


//    public int[][] reconstructQueue(int[][] people) {
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
//            }
//        });
//        int len = people.length;
//        List<int[]> list =  new LinkedList<>();
//        for (int i = 1; i < len; i++) {
//            build(list, people[i]);
//        }
//        for (int i = 0; i < len; i++) {
//            people[i] = list.get(i);
//        }
//        return people;
//    }
//
//    private void build(List<int[]> list, int[] peo) {
//        int count = 0;
//        int i = 0;
//        for (; i < list.size(); i++) {
//            if(count == peo[1]) {
//                break;
//            }
//            if(list.get(i)[0] >= peo[0]) {
//                count++;
//            }
//        }
//        // 当前位置开始就是出现次数为peo[0]的位置
//        while(i < list.size() && peo[0] > list.get(i)[0]) {
//            i++;
//        }
//        list.add(i, peo);
//    }
}
