package offer;

public class Off39_MajorityElement {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                num = nums[i];
                count = 1;
                continue;
            }
            if(num == nums[i]) {
                count++;
            }else {
                count--;
            }
        }
        return num;
    }
}
