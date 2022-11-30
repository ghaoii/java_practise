package leetcode.dp;

public class Num97_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < s3.length(); k++) {
            if(i == s1.length() && j == s2.length()) {
                return false;
            }

            char c3 = s3.charAt(k);

            if(i == s1.length()) {
                if(s2.charAt(j) == c3) {
                    continue;
                }
                return false;
            }

            if(j == s2.length()) {
                if(s1.charAt(i) == c3) {
                    continue;
                }
                return false;
            }

            char c1 = s1.charAt(i);
            char c2 =  s2.charAt(j);


        }

        return true;
    }

}
