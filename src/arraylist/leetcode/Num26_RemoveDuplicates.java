package arraylist.leetcode;

public class Num26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[slow] != nums[fast]) {
                // 如果不同则说明第一次出现
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow + 1;
    }


//    public int removeDuplicates(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        while(fast < nums.length){
//            if(nums[slow] != nums[fast]){
//                nums[slow + 1] = nums[fast];
//                slow++;
//            }
//            fast++;
//        }
//        return slow + 1;
//    }
}
