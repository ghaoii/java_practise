package arraylist.leetcode;

public class Num283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }

//    public void moveZeroes(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        while(fast < nums.length){
//            if(nums[fast] != 0){
//                int tmp = nums[slow];
//                nums[slow] = nums[fast];
//                nums[fast] = tmp;
//                slow++;
//            }
//            fast++;
//        }
//    }
}
