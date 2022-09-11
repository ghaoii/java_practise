package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(str);
            int i = 0;
            int j = 0;
            while(j <= str.length()) {
                if(j < str.length() && str.charAt(i) == str.charAt(j)) {
                    j++;
                    continue;
                }
                if(j - i >= 3) {
                    stringBuilder.delete(i, j);
                    str = stringBuilder.toString();
                    while(i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        i--;
                    }
                    j = i + 1;
                }else {
                    i = j;
                    j++;
                }
            }
            if(j - i >= 3) {
                stringBuilder.delete(i, j);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
