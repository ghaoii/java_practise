package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Num22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, 0, sb, ret);
        return ret;
    }

    private void dfs(int n, int pair, int left, int right, StringBuilder sb, List<String> list) {
        if(pair == n) {
            list.add(sb.toString());
            return;
        }
        // 可以加'('的情况
        if(left < n) {
            sb.append('(');
            dfs(n, pair, left + 1, right, sb, list);
            sb.delete(sb.length() - 1, sb.length());
        }
        // 可以加')'的情况
        if(left > right) {
            sb.append(')');
            dfs(n, pair + 1, left, right + 1, sb, list);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
