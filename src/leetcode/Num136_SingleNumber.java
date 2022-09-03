package leetcode;

public class Num136_SingleNumber {
    public int singleNumber(int[] nums) {
        int i = nums[0];
        for (int j = 1; j < nums.length; j++) {
            i ^= nums[j];
        }
        return i;
    }
}
