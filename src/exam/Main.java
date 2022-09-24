package exam;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int k = scanner.nextInt();
//            int v = scanner.nextInt();
//
//            int count = 0;
//            while(a > 0) {
//                if(b > 0) {
//                    int min = Math.min(k, b + 1);
//                    a -= min * v;
//                    b -= min - 1;
//                }else {
//                    a -= v;
//                }
//                count++;
//            }
//            System.out.println(count);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            String s = scanner.nextLine();
            String t = scanner.nextLine();
            int len = s.length();
            if(len > t.length()) {
                System.out.println("NO");
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < t.length(); j++) {
                if(j < len) {
                    if(s.charAt(j) != t.charAt(j)) {
                        flag = false;
                        break;
                    }
                    set.add(s.charAt(j));
                }else {
                    char ch = t.charAt(j);
                    if(!set.contains(ch)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
