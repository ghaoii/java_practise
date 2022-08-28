package offer;

public class Off16_MyPow {
    // 未解决
    public double myPow(double x, int n) {
        if(x == 0) {
            return x;
        }
        long num = n;
        if(n >= 0) {
            return helper(x, num);
        }else {
            return 1.0 / helper(x, -num);
        }
    }

    private double helper(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        double ret = helper(x, n >> 1);
        ret *= ret;
        if((n & 1) == 1) {
            // n是偶数
            ret *= x;
        }
        return ret;
    }
}
