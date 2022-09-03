package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String except = scanner.nextLine().toUpperCase();
            String actual = scanner.nextLine().toUpperCase();
            Set<Character> set = new HashSet<>();
            for(char ch : actual.toCharArray()) {
                set.add(ch);
            }
            Set<Character> broke = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for(char ch : except.toCharArray()) {
                if(!set.contains(ch) && !broke.contains(ch)) {
                    sb.append(ch);
                    broke.add(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }

}

