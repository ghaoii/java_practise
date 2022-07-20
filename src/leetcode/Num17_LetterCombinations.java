package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num17_LetterCombinations {
    private List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return ret;
        }
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, str, sb);
        return ret;
    }

    private void dfs(String digits, int curPos, String[] str, StringBuilder sb) {
        if(curPos == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        String letter = str[digits.charAt(curPos) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            dfs(digits, curPos + 1, str, sb);
            sb.delete(curPos, curPos + 1);
        }
    }

    public static void main(String[] args) {
        Num17_LetterCombinations test = new Num17_LetterCombinations();
        List<String> ret = test.letterCombinations("23");
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }
}
