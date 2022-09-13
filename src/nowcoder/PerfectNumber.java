package nowcoder;

import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int count = 0;
            for (int i = 4; i <= n; i++) {
                if(isPerfect(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0 && i * i != num) {
                sum += i + num / i;
            }else if(i * i == num) {
                sum += i;
            }
        }
        return sum == num;
    }
}
