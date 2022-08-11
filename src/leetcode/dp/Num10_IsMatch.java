package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Num10_IsMatch {
    // 字符串用中包含了两个字符串，用逗号分隔，value是两个字符串的匹配情况
    Map<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    // 递归匹配
    private boolean dp(String s, int i, String p, int j) {
        // 递归中止条件
        if(j == p.length()) {
            // p已经匹配完了，如果s匹配完了才说明匹配成功
            return i == s.length();
        }
        if(i == s.length()) {
            // s匹配完了，只有当剩下的p是x*y*z*这种表达式才匹配成功
            // 如果是上述这种表达式，一定是偶数个字符，否则匹配失败
            if((p.length() - j) % 2 == 1) {
                return false;
            }
            // 如果是偶数，则一直匹配到最后
            while(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                j += 2;
            }
            return j == p.length();
        }

        // 进入正题，开始匹配
        // 查看当前字符串是否已匹配过，如果存在匹配结果则直接返回
        String str = s.substring(i) + "," + p.substring(j);
        if(map.containsKey(str)) {
            return map.get(str);
        }
        // 如果没有匹配过，则开始判断
        boolean flag = false;
        // 如果i和j所指向的字符相同，或者j指向的字符是'.'，则继续匹配
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 如果后面是'*'通配符
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 匹配0次或多次(0次的情况:aa, a*aa;多次的情况:aaa,a*)
                flag = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            }else {
                // 如果不是'*'匹配，那么各自向后走一步
                flag = dp(s, i + 1, p, j + 1);
            }
        }else {
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // i和j所指向的字符不匹配，并且是'*'通配符的0次匹配
                flag = dp(s, i, p, j + 2);
            }else {
                // 如果不是'*'0次匹配，那么一定就是匹配失败
                flag = false;
            }
        }
        map.put(str, flag);
        return flag;
    }
}
