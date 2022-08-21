package offer;

public class Off14_2_CuttingRope {
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        if(n == 4) {
            return 4;
        }
        long ret = 1;
        int i = 0;
        int p = (int)1e9+7;
        for (i = n; i >= 5; i -= 3) {
            ret *= 3;
            ret %= p;
        }
        ret *= i;
        ret %= p;
        return (int) ret;
    }

    public static void main(String[] args) {
        Off14_2_CuttingRope test = new Off14_2_CuttingRope();
        int ret = test.cuttingRope(120);
        System.out.println(ret);
    }
}
