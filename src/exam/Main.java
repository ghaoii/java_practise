package exam;

import java.util.*;

public class Main {
    private static final int M = 10_0000_0007;

    private static int count = 0;

//    private static Set<Long> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        dfs(len, k, s, 0, 0);
        System.out.println(count);
    }

    private static void dfs(int len, int k, String s, int pos, long num) {
        if(pos == len) {
            if(num != 0 && num % k == 0) {
                count++;
            }
            return;
        }
        dfs(len, k, s, pos + 1, num);
        long temp = num * 10 + (s.charAt(pos) - '0');
        temp %= M;
        dfs(len, k, s, pos + 1, temp);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scanner.nextInt();
//        }
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
//}