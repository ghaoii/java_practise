package leetcode.dfs;

import java.util.LinkedList;
import java.util.List;

public class Num312_MaxCoins {
    int max = 0;
    public int maxCoins(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for(int i : nums) {
            list.add(i);
        }
        dfs(list, 0, list.size() - 1, 0);
        return max;
    }

    private void dfs(List<Integer> list, int curPos, int maxIndex, int sum) {
        if(curPos > maxIndex) {
            max = Math.max(max, sum);
        }
        for (int i = 0; i < list.size(); i++) {
            int left = i - 1 < 0 ? 1 : list.get(i - 1);
            int cur = list.get(i);
            int right = i + 1 >= list.size() ? 1 : list.get(i + 1);
            int mul = left * cur * right;
            sum += mul;
            list.remove(i);
            dfs(list, curPos + 1, maxIndex, sum);
            list.add(i, cur);
            sum -= mul;
        }
    }
}
