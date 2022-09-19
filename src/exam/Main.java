package exam;

import java.util.*;

public class Main {
    private static int ret = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dfs(n, k, nums, new HashMap<>(), i, 0, 0);
        }
        System.out.println(ret);
    }

    private static void dfs(int n, int k, int[] nums, Map<Integer, Integer> map, int cur, int max, int maxCount) {
        if(cur == n) {
            return;
        }
        map.put(nums[cur], map.getOrDefault(map.get(nums[cur]), 0) + 1);
        if(nums[cur] == max) {
            maxCount++;
        }else if(map.get(nums[cur]) > maxCount){
            maxCount = map.get(nums[cur]);
            max = nums[cur];
        }
        if(maxCount >= k) {
            ret++;
        }
        dfs(n, k, nums, map, cur + 1, max, maxCount);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        if(n == 1) {
//            System.out.println(0);
//            return;
//        }
//        int k = scanner.nextInt();
//        int[] height = new int[n];
//        for (int i = 0; i < n; i++) {
//            height[i] = scanner.nextInt();
//        }
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = Integer.MAX_VALUE;
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= k; j++) {
//                if(i - j >= 0) {
//                    if(height[i] >= height[i - j]) {
//                        dp[i] = Math.min(dp[i], dp[i - j] + (height[i] - height[i - j]));
//                    }else {
//                        dp[i] = Math.min(dp[i], dp[i - j]);
//                    }
//                }
//            }
//        }
//        System.out.println(dp[n - 1]);
//    }
//
////    private static int min = Integer.MAX_VALUE;
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        if(n == 1) {
////            System.out.println(0);
////            return;
////        }
////        int k = scanner.nextInt();
////        int[] height = new int[n];
////        for (int i = 0; i < n; i++) {
////            height[i] = scanner.nextInt();
////        }
////        dfs(n, k, height, 1, 0);
////        System.out.println(min);
////    }
////
////    private static void dfs(int n, int k, int[] height, int cur, int money) {
////        if(cur == n) {
////            min = Math.min(min, money);
////            return;
////        }
////        for (int i = 1; i <= k; i++) {
////            if(cur + i <= n) {
////                dfs(n, k, height, cur + i, money + Math.max(0, height[cur + i - 1] - height[cur - 1]));
////            }
////        }
////    }
//}

//public class Main {
//    private static Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        int d = scanner.nextInt();
//        int x = scanner.nextInt();
//        int ret = Math.min(isGood(a, x), isGood(b, x));
//        ret = Math.min(ret, isGood(c, x));
//        ret = Math.min(ret, isGood(d, x));
//        System.out.println(ret);
//    }
//
//    private static int isGood(int num, int x) {
//        int count = 0;
//        for (int i = 0; i < num; i++) {
//            int score = scanner.nextInt();
//            if(score >= x) {
//                count++;
//            }
//        }
//        return count;
//    }
//}
