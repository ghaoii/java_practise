package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num78_Subsets {
    private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int[] book = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        ret.add(new ArrayList<>());
        dfs(nums, book, 0, list);
        return ret;
    }

    private void dfs(int[] arr, int[] book, int curPos, List<Integer> list) {
        if(curPos == arr.length) {
            return;
        }
        for (int i = curPos; i < arr.length; i++) {
            if(book[i] == 0) {
                book[i] = 1;
                list.add(arr[i]);
                List<Integer> temp = new ArrayList<>(list);
                ret.add(temp);
                dfs(arr, book,  i + 1, list);
                book[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }
}
