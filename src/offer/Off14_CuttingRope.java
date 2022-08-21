package offer;

public class Off14_CuttingRope {
    // 贪心
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }

    // 剑指offer中的动归算法
//    public int cuttingRope(int n) {
//        if(n == 2) {
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 1;
//        dp[3] = 2;
//        int max = 0;
//        for(int i = 4; i <= n; i++) {
//            // 超过一般之后的都是重复计算，可以剪枝
//            for (int j = 1; j <= i / 2; j++) {
//                int temp = Math.max(j * (i - j), j * dp[i - j]);
//                dp[i] = Math.max(dp[i], temp);
//            }
//        }
//        return dp[n];
//    }

//    public int cuttingRope(int n) {
//        int[][] dp = new int[n + 1][n + 1];
//        for(int i = 1; i <= n; i++) {
//            dp[1][i] = i;
//        }
//        for(int i  = 2; i <= n; i++) {
//            for(int j = 2; j <= n; j++) {
//                int num = j / i;
//                dp[i][j] = num * dp[i - 1][j - num];
//            }
//        }
//        int max = 1;
//        for (int i = 2; i <= n; i++) {
//            max = Math.max(max, dp[i][n]);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        Off14_CuttingRope test = new Off14_CuttingRope();
        int ret = test.cuttingRope(2);
        System.out.println(ret);
    }
}
