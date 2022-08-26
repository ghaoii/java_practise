package offer;

public class Off16_MyPow {
    // 未解决
    public double myPow(double x, int n) {
        if(x == 0) {
            return x;
        }

        if(n == 0) {
            return 1.0;
        }
        boolean flag = n > 0;
        n = Math.abs(n);
        int i = 1;
        double ret = x;
        while(i * 2 <= n) {
            ret *= ret;
            i *= 2;
        }
        while (i < n) {
            ret *= x;
            i++;
        }
        return flag ? ret : 1.0 / ret;
    }
}
