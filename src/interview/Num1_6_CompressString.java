package interview;

public class Num1_6_CompressString {
    public String compressString(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int count = 1;
            while(i < S.length() - 1 && S.charAt(i + 1) == c) {
                count++;
                i++;
            }
            sb.append(c).append(count);
        }

        return sb.length() >= S.length() ? S : sb.toString();
    }
}
