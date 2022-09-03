package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num219_ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }else {
                map.put(num, i);
            }
        }
        return false;
    }
}
