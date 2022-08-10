package offer;

public class Off3_FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for(int i : nums) {
            if(hash[i] != 0) {
                return i;
            }
            hash[i]++;
        }
        return -1;
    }
}
