package offer;

public class Off20_IsNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return false;
        }
        if(s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        boolean point = false;
        boolean hasE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-') {
                if(i > 0 ) {
                    char prev = s.charAt(i - 1);
                    if(prev != 'e' && prev != 'E') {
                        return false;
                    }
                }
                if(i == s.length() - 1)
                    return false;

            }else if(c == '.' && !point && !hasE) {
                point = true;
                if(i == 0 && i == s.length() - 1)
                    return false;

                if(i == 0) {
                    char next = s.charAt(i + 1);
                    if(next < '0' || next > '9')
                        return false;
                }
                if(i == s.length() - 1) {
                    char prev = s.charAt(i - 1);
                    if(prev < '0' || prev > '9')
                        return false;
                }

                if(i == 0 || i == s.length() - 1)
                    continue;

                char prev = s.charAt(i - 1);
                if(prev == '.')
                    continue;
                if(prev < '0' || prev > '9')
                    return false;

                char next = s.charAt(i + 1);
                if(next != '.' && (next < '0' || next > '9'))
                    return false;

            }else if((c == 'E' || c == 'e') && !hasE) {
                hasE = true;
                if(i == 0 || i == s.length() - 1)
                    return false;
                char next = s.charAt(i + 1);
                if(next == '+' || next == '-')
                    continue;
                if(next < '0' || next > '9')
                    return false;
            }else if(c >= '0' && c <= '9')
                continue;
            else
                return false;

        }
        return true;
    }
}
