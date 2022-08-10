package leetcode;

public class Num581_FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if(nums[i] < max) {
                end = i;
            }else {
                max = nums[i];
            }
            int j = len - 1 - i;
            if(min < nums[j]) {
                start = j;
            }else {
                min = nums[j];
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Num581_FindUnsortedSubarray test = new Num581_FindUnsortedSubarray();
        int[] arr = {1,2,4,5,3};
        int ret = test.findUnsortedSubarray(arr);
        System.out.println(ret);
    }
}
