package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Off57_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        List<List<Integer>> res = new ArrayList<>();
        int sum = 1;
        int max = 0;
        while(true) {
            sum += right;

            while(sum > target) {
                sum -= left;
                left++;
            }

            if(left == right) {
                break;
            }

            if(sum == target) {
                List<Integer> list = new LinkedList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                max = Math.max(max, list.size());
            }
            right++;
        }

        int[][] ret = new int[res.size()][max];
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            int[] arr = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr[j] = list.get(j);
            }
            ret[i] = arr;
        }
        return ret;
    }

    public static void main(String[] args) {
        Off57_FindContinuousSequence test = new Off57_FindContinuousSequence();
        test.findContinuousSequence(9);
    }
}
