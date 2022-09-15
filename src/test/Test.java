package test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;



public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if(m > n) {
                int temp = m;
                m = n;
                n = temp;
            }

            int sum = 0;
            int count = 0;
            for(int i = m; i <= n; i++) {
                if((i / 100) % 2 == 0) {
                    i += 99;
                    continue;
                }
                if((i / 10) % 2 == 0) {
                    i += 9;
                    continue;
                }
                if((i & 1) == 1) {
                    sum += i;
                    count++;
                }
//                if(isAllOdd(i)) {
//                    sum += i;
//                    count++;
//                }
            }
            int ret = sum == 0 ? 0 : sum / count;
            System.out.println(ret);
        }
    }

    private static boolean isAllOdd(int num) {
        while(num > 0) {
            int n = num % 10;
            if((n & 1) == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}

