package arraylist.leetcode;

public class Num27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

//    public int removeElement(int[] nums, int val) {
//        int slow = 0;
//        int fast = 0;
//        while(fast < nums.length){
//            if(nums[fast] != val){
//                nums[slow] = nums[fast];
//                slow++;
//            }
//            fast++;
//        }
//        return slow;
//    }
}
