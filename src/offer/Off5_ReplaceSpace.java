package offer;

public class Off5_ReplaceSpace {
    public String replaceSpace(String s) {
        if(s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                sb.append("%20");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
