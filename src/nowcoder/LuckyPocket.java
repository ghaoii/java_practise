package nowcoder;

import java.util.*;

public class LuckyPocket {
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] bolls = new int[n];
            for (int i = 0; i < n; i++) {
                bolls[i] = scanner.nextInt();
            }
            // 如果球不足两个，肯定不是幸运的袋子
            if(n < 2) {
                System.out.println(0);
                continue;
            }
            // 对所有的球按照升序排列
            Arrays.sort(bolls);

            count = 0;// 初始化计数器
            // 从第二个球开始判断，因为只有一个球的时候不可能幸运
            dfs(bolls, 1, bolls[0], bolls[0]);
            System.out.println(count);
        }
    }

    private static void dfs(int[] bolls, int cur , int sum, int mul) {
        for (int i = cur; i < bolls.length; i++) {
            sum += bolls[i];
            mul *= bolls[i];
            if(sum <= mul) {
                // 如果当前已经是不幸运的了，后面的球也没必要判断了
                return;
            }
            // 如果是幸运的，就让计数器加1，继续dfs
            count++;
            dfs(bolls, i + 1, sum, mul);
            // 回溯，判断下一个球
            sum -= bolls[i];
            mul /= bolls[i];
            // 跳过已经判断过的球号
            while(i < bolls.length - 1 && bolls[i] == bolls[i + 1]) {
                i++;
            }
        }
    }
}
