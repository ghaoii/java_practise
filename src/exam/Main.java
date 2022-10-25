package exam;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 100000; i++) {
            if(helper(i)) {
                list.add(i);
            }
        }
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int count = 0;
            for(int i : list) {
                if(num % i == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean helper(int num) {
        if(num == 2) {
            return true;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}