package leetcode;

import java.util.HashMap;
import java.util.Map;


// dp算法
public class Num115_NumDistinct {
    // 常规dp
    public int numDistinct(String s, String t) {
        if(t.length() == 0) {
            return 1;
        }

        if(s.length() == 0) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }
}


//dfs+备忘录
//public class Num115_NumDistinct {
//    private Map<String, Integer> map = new HashMap<>();// 备忘录
//
//    public int numDistinct(String s, String t) {
//        return dfs(s, t, 0, 0);
//    }
//
//    private int dfs(String s, String t, int i, int j) {
//        // 如果 t 字符串已经匹配完了，就返回1，表示找到一种结果
//        if(j == t.length()) {
//            return 1;
//        }
//
//        // 如果s字符串已经匹配完了而t字符串还没匹配完，就返回0，表示没有找到可行解
//        if(i == s.length()) {
//            return 0;
//        }
//
//        // 搜索备忘录，如果已经计算过了，就直接返回
//        String str = i + "," + j;
//        if(map.containsKey(str)) {
//            return map.get(str);
//        }
//
//        int num = 0;
//
//        if(s.charAt(i) == t.charAt(j)) {
//            // 如果两个字符相同，继续向后匹配或跳过s的当前字符
//            num = dfs(s, t, i + 1, j + 1) + dfs(s, t, i + 1, j);
//        }else {
//            // 如果两个字符不相同，则跳过s的当前字符
//            num = dfs(s, t, i + 1, j);
//        }
//
//        // 将结果保存到备忘录中
//        map.put(str, num);
//        return num;
//    }
//}
