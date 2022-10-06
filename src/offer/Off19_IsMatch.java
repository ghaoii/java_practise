package offer;

import java.util.HashMap;
import java.util.Map;

public class Off19_IsMatch {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0, new HashMap<>());
    }

    private boolean helper(String s, String p, int i, int j, Map<String, Boolean> map) {
        if(j == p.length()) {
            return i == s.length();
        }
        if(i == s.length()) {
            if((p.length() - j) % 2 == 1) {
                return false;
            }
            for( ; j < p.length() - 1; j += 2) {
                if(p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        String str = s.substring(0, i + 1) + "," + p.substring(0, j + 1);
        if(map.containsKey(str)) {
            return map.get(str);
        }
        boolean flag = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 匹配多次或者不匹配
                flag = helper(s, p, i + 1, j, map) || helper(s, p, i, j + 2, map);
            }else {
                // 只能一对一匹配
                flag = helper(s, p, i + 1, j + 1, map);
            }
        }else {
            if(j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 这种情况只能不匹配
                flag = helper(s, p, i, j + 2, map);
            }
        }
        map.put(str, flag);
        return flag;
    }
}
