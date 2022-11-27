package offer;

public class Off60_DicesProbability {
    public double[] dicesProbability(int n) {
        int count = 6 * n;// 能投出的最大点数
        int[][] dp = new int[n + 1][count + 1];

        // base case
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int x = 6 * i;// 当前骰子个数所能投出的最大点数
            for (int j = i; j <= x; j++) {
                // 一个骰子能投出1~6之间的点数，遍历每种情况
                for (int k = 1; k <= 6; k++) {
                    if(k <= j) {
                        // 只有当投出点数小于等于所求点数时才代入状态转移方程
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        double[] res = new double[count - n + 1];
        int index = 0;

        double num = Math.pow(6, n);// n 个骰子所能投出的结果数
        for (int i = n; i <= count; i++) {
            res[index++] = dp[n][i] / num;
        }
        return res;
    }
}
