package offer;

public class Off44_FindNthDigit {
    public int findNthDigit(int n) {
        if(n < 10) {
            return n;
        }
        n -= 10;
        int digit = 10;
        int i = 2;
        int count = 9 * digit * i;
        while(count < n) {
            digit *= 10;
            i++;
            n -= count;
            count = 9 * digit * i;
        }
        long num = digit + n / i;
        String s = String.valueOf(num);
        return s.charAt(n % i) - '0';
    }

    // 暴力解法，时间复杂度过高
//    public int findNthDigit(int n) {
//        StringBuilder sb = new StringBuilder();
//        int num = 1;
//        int ret = -1;
//        while(true) {
//            sb.append(num);
//            if(sb.length() >= n) {
//                return sb.charAt(n - 1) - '0';
//            }
//            num++;
//        }
//    }
}
