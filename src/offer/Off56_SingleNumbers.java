package offer;

public class Off56_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        // 找到异或后的结果中，最低位的1的位置
        int k = 1;
        while((n & k) == 0) {
            k <<= 1;
        }
        // 根据二进制数中k位是否为1将原数组分成两部分
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & k) == 0) {
                // k位不为1
                num1 ^= num;
            } else {
                // k位为1
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
