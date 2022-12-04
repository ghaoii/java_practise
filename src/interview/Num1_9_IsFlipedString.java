package interview;

public class Num1_9_IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        s2 = s2 + s2;
        return s2.contains(s1);
    }
}
