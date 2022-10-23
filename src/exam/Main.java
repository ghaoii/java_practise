package exam;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if(n == 0) {
                return;
            }
            if(n == 1) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            while(n > 3) {
                if(n % 3 == 0) {
                    n /= 3;
                }else {
                    n = n / 3 + 1;
                }
                count++;
            }
            System.out.println(++count);
        }
    }
}