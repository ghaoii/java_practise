package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long maxVal = 0;// 初始化为0
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int lastRoom = 0;
        for(int i = 0; i < n; i++) {
            int room = scanner.nextInt();
            list.add(room);
            lastRoom = Math.max(lastRoom, room);
        }
        for(int i = 0; i < n; i++) {
            map.put(list.get(i), scanner.nextInt());
        }
        long[] dp = new long[lastRoom + 1];
        for(int i = 1; i <= lastRoom; i++) {
            if(map.containsKey(i)) {
                dp[i] += map.get(i);
            }
            dp[i] += dp[i / 2];
            maxVal = Math.max(maxVal, dp[i]);
        }
        System.out.println(maxVal);
//        while(scanner.hasNextInt()) {
//
//        }
    }
}
