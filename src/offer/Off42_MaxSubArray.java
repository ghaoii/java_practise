package offer;

public class Off42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = -100;
        int max = -100;
        for(int num : nums) {
            if(num >= sum && sum < 0) {
                // 如果前面的子数组之和小于0，并且当前元素已经大于前面子数组的和时
                // 重新开始
                sum = num;
            }else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
