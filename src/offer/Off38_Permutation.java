package offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Off38_Permutation {
    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        if(s == null || s.length() == 0) {
            return new String[0];
        }
        helper(s, 0, new StringBuilder(), new int[s.length()]);
        String[] res = new String[set.size()];
        int i = 0;
        for(String str : set) {
            res[i] = str;
            i++;
        }
        return res;
    }

    private void helper(String s, int cur, StringBuilder sb, int[] book) {
        if(cur == s.length()) {
            set.add(sb.toString());
        }

        for (int i = 0; i < s.length(); i++) {
            if(book[i] == 0) {
                book[i] = 1;
                sb.append(s.charAt(i));
                helper(s, cur + 1, sb, book);
                sb.deleteCharAt(sb.length() - 1);
                book[i] = 0;
            }
        }
    }
}
