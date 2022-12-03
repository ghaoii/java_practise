package interview;

public class Num1_3_ReplaceSpaces {
    public String replaceSpaces(String S, int length) {
        if(length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if(i >= S.length() || S.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
