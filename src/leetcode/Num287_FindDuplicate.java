package leetcode;

public class Num287_FindDuplicate {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                break;
            }
        }
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
