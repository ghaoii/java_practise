package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[m + 1];
            for (int i = n + 1; i <= m; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = n; j < i; j++) {
                    if(i - j != 1 && j != (i - j) && j % (i - j) == 0) {
                        if(j == n) {
                            min = 0;
                        }else {
                            min = Math.min(min, nums[j]);
                        }
                    }
                }
                nums[i] = min == Integer.MAX_VALUE ? 0 : min + 1;
            }
            int ret = nums[m] == 0 ? -1 : nums[m];
            System.out.println(ret);
        }
    }

    private static int bfs(int[][] nums, int n, int m) {
        int step = 0;
        Set<Integer> book = new HashSet<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curPos = queue.poll();
                for(int j = 2; j <= curPos; j++) {
                    if(nums[curPos - n][j] == 1) {
                        int temp = curPos + j;
                        if(temp == m) {
                            return step + 1;
                        }
                        if(temp < m && !book.contains(temp)) {
                            queue.offer(temp);
                            book.add(temp);
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }
}