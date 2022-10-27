package exam;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int num = scanner.nextInt();
            System.out.print(num + " = ");
            helper(num);
            System.out.println();
        }
    }

    private static void helper(int num) {
        if(num == 1) {
            return;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                int next = num / i;
                if(next == 1) {
                    System.out.print(i);
                }else {
                    System.out.print(i + " * ");
                }
                helper(next);
                return;
            }
        }
        System.out.print(num);
    }
}