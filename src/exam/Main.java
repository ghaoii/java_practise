package exam;

import java.util.*;

//class Pair {
//    int one;
//    int two;
//}

public class Main {
    private static final int M = 10_0000_0007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if(n < 3) {
                System.out.println(0);
                continue;
            }
            if(n == 3) {
                System.out.println(1);
                continue;
            }
            long[][] dp = new long[n][n];
            dp[0][0] = 1;
            for (int i = 0; i <= n - 3; i++) {
                if(i > 0) {
                    dp[i][0] = 26;
                }
                for (int j = 1; j < n; j++) {
                    if(j < i) {
                        if(j < 2) {
                            dp[i][j]=  dp[i][j - 1] * 26;
                        }else {
                            dp[i][j] = dp[i][j - 1] * 25;
                        }
                    }else if(j - i < 3) {
                        if(j - i >= 4) {
                            dp[i][j] = dp[i][j - 1] * 25;
                        }else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
                    dp[i][j] %= M;
                }
            }
            long count = 0;
            for (int i = 0; i <= n - 3; i++) {
                count += dp[i][n - 1];
                count %= M;
            }
            System.out.println(count);
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//            int[] arr = new int[n];
//            for(int i = 0;i < n; i++) {
//                arr[i] = scanner.nextInt();
//            }
//            int pos = 0;
//            int count = 0;
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < n; i++) {
//                if(arr[i] <= k && !set.contains(arr[i])) {
//                    set.add(arr[i]);
//                    swap(arr, i, pos);
//                    count += i - pos;
//                    pos++;
//                }
//                if(pos == k) {
//                    break;
//                }
//            }
//            System.out.println(count);
//        }
//    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            if(a - b > 1 || b == 0) {
//                System.out.println(-1);
//                continue;
//            }
//
//            int[] arr = new int[a + b];
//            int i = 0;
//            while(a > 0 || b > 0) {
//                if(a == 0) {
//                    arr[i] = 2;
//                    i++;
//                    b--;
//                    continue;
//                }
//
//                if((i & 1) == 0) {
//                    arr[i] = 1;
//                    a--;
//                }else {
//                    arr[i] = 2;
//                    b--;
//                }
//                i++;
//            }
////            for (int i = 0; i < arr.length; i++) {
////                if(a == 0) {
////                    arr[i] = 2;
////                    continue;
////                }
////                if((i & 1) == 0) {
////                    arr[i] = 1;
////                    a--;
////                }else {
////                    arr[i] = 2;
////                    b--;
////                }
////            }
//            System.out.println(Arrays.toString(arr));
//        }
//    }
}
