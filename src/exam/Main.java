package exam;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        int prev = 0;
        for (int i = 1; i <= 2005; i++) {
            int num = i;
            List<Integer> list = new LinkedList<>();
            while(num > 0) {
                list.add(num % 10);
                num /= 10;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                int n = prev * 10 + list.get(j);
                prev = n % 9;
            }
        }
        System.out.println(prev);
    }

}