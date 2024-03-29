package leetcode;

public class Num26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }
}
