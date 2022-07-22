package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Num56_Merge {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if(len == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        List<Pair> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            boolean flag = false;
            if(intervals[i][0] <= intervals[i - 1][1]) {
                flag = true;
                intervals[i][0] = intervals[i - 1][0];
            }
            if (intervals[i][1] <= intervals[i - 1][1]) {
                flag = true;
                intervals[i][1] = intervals[i - 1][1];
            }
            if(!flag){
                list.add(new Pair(intervals[i - 1][0], intervals[i - 1][1]));
            }
        }
        list.add(new Pair(intervals[len - 1][0], intervals[len - 1][1]));
        int[][] ret = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ret[i][0] = list.get(i).left;
            ret[i][1] = list.get(i).right;
        }
        return ret;
    }
}
