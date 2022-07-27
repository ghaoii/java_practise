package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Num96_NumTrees {
    // dp
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    // 备忘录
//    Map<Integer, Integer> map = new HashMap<>();
//    //  传入节点数，就能返回BST的构造种数
//    public int numTrees(int n) {
//        if(n == 0 || n == 1) {
//            return 1;
//        }
//        if(map.containsKey(n)) {
//            return map.get(n);
//        }
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            int left = numTrees(i - 1);
//            int right = numTrees(n - i);
//            count += left * right;
//        }
//        map.put(n, count);
//        return count;
//    }
}
