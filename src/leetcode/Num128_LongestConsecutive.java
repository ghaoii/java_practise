package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Num128_LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        int count = 0;
        for(int i : set) {
            if(!set.contains(i - 1)) {
                int num = i;
                // 如果是一个连续序列的第一位，则开始统计
                while(set.contains(num + 1)) {
                    num++;
                }
                count = Math.max(count, num - i + 1);
            }
        }
        return count;
    }
}
