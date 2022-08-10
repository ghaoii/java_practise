package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Num448_FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        int len = nums.length;
        int[] hashTable = new int[len + 1];
        for(int i : nums) {
            hashTable[i]++;
        }
        for (int i = 1; i <= len; i++) {
            if(hashTable[i] == 0) {
                ret.add(i);
            }
        }
        return ret;
    }
}
