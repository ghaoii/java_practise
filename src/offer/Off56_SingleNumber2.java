package offer;

public class Off56_SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] arr = new int[32];// 记录每个二进制位出现1的次数
        for(int num : nums) {
            int k = 1;
            for (int i = 31; i >= 0; i--, k <<= 1) {
                if((num & k) == k) {
                    // num的当前二进制位为1
                    arr[i]++;
                }
            }
        }
        int num = 0;
        for(int n : arr) {
            num <<= 1;
            // 如果当前二进制位不能被3整除，那么只出现了一次的数字的对应二进制位为1
            num += n % 3;
        }
        return num;
    }

    public static void main(String[] args) {
        Off56_SingleNumber2 test = new Off56_SingleNumber2();
        int[] arr = {3,4,3,3};
        test.singleNumber(arr);
    }
}
