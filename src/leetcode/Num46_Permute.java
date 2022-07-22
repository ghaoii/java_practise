package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curRes = new ArrayList<>();
        int[] book = new int[nums.length];
        dfs(nums, book, 0, curRes, ret);
        return ret;
    }

    private void dfs(int[] nums, int[] book, int curPos, List<Integer> curRes, List<List<Integer>> ret) {
        if(curPos == nums.length) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curRes);
            ret.add(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(book[i] == 0) {
                curRes.add(nums[i]);
                book[i] = 1;
                dfs(nums, book, curPos + 1, curRes, ret);
                book[i] = 0;
                curRes.remove(curPos);
            }
        }
    }
}
