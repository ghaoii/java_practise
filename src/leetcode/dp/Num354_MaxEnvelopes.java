package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Num354_MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int left = 0;
            int right = list.size();

            while(left < right) {
                int mid = left + (right - left) / 2;
                if(list.get(mid) == envelopes[i][1]) {
                    right = mid;
                }else if(list.get(mid) < envelopes[i][1]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            if(left == list.size()) {
                list.add(envelopes[i][1]);
            }else {
                list.set(left, envelopes[i][1]);
            }
        }

        return list.size();
    }
}
