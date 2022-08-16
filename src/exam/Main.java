package exam;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            String[] strs = new String[num];
            for(int i = 0; i < num; i++) {
                strs[i] = scanner.next();
            }
            String bro = scanner.next();
            int k = scanner.nextInt();
            List<String> list = new LinkedList<>();
            int count = 0;
            for(int i = 0; i < num; i++) {
                if(brotherWord(strs[i], bro)) {
                    count++;
                    list.add(strs[i]);
                }
            };
            System.out.println(count);
            if(count == 0) {
                System.out.println("");
                continue;
            }
            String[] temp = new String[count];
            for(int i = 0; i < count; i++) {
                list.add(temp[i]);
            }
            Arrays.sort(temp);
            System.out.println(temp[k - 1]);

        }
    }

    private static boolean brotherWord(String str1, String str2) {
        if(str1.equals(str2)) {
            return true;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 != len2) {
            return false;
        }
        int[] letter = new int[26];
        for(int i = 0; i < len1; i++) {
            letter[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < len2; i++) {
            int index = str2.charAt(i) - 'a';
            if(letter[index] == 0) {
                return false;
            }
        }
        return true;
    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            char[][] board = new char[20][20];
//            for(int i = 0; i < 20; i++) {
//                board[i] = scanner.nextLine().toCharArray();
//            }
//            String[][] dp = new String[21][21];
//            for(int i = 0; i < 21; i++) {
//                dp[0][i] = "0,0,0";
//            }
//            for(int i = 1; i < 21; i++) {
//                dp[i][0] = "0,0,0";
//            }
//            boolean flag = false;
//            for(int i = 1; i < 21; i++) {
//                for(int j = 1; j < 21; j++) {
//                    char ch = board[i - 1][j - 1];
//                    if(ch == '.') {
//                        dp[i][j] = "0,0,0";
//                        continue;
//                    }
//                    int a = board[i - 2][j - 1] == ch ? dp[i - 1][j].charAt(0) - '0' + 1 : 1;
//                    int b = board[i - 1][j - 2] == ch ? dp[i][j - 1].charAt(2) - '0' + 1 : 1;
//                    int c = board[i - 2][j - 2] == ch ? dp[i - 1][j - 1].charAt(4) - '0' + 1 : 1;
//                    if(a == 5 || b == 5 || c == 5) {
//                        flag = true;
//                        break;
//                    }
//                    dp[i][j] = a + "," + b + "," + c;
//                }
//                if(flag) {
//                    break;
//                }
//            }
//            String str = "NO";
//            if(flag) {
//                str = "Yes";
//            }
//            System.out.println(str);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int k = scanner.nextInt();
//            int[][] mushroom = new int[m + 1][n + 1];
//            for(int i = 0; i < k; i++) {
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//                mushroom[y][x] = 1;
//            }
//            double[][] grass = new double[m + 1][n + 1];
//            grass[1][1] = 1;
//            for(int i = 1; i <= m; i++) {
//                for(int j = 1; j <= n; j++) {
//                    if(mushroom[i][j] == 1) {
//                        grass[i][j] = 0;
//                        continue;
//                    }
//                    if(i != 1 || j != 1) {
//                        grass[i][j] = grass[i - 1][j] * (j == n ? 1.0 : 0.5) + grass[i][j - 1] * (i == m ? 1.0 : 0.5);
//                    }
//                }
//            }
//            System.out.printf("%.2f", grass[m][n]);
//        }
//    }

//    private static int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            int row = scanner.nextInt();
//            int col = scanner.nextInt();
//            scanner.nextLine();
//            char[][] floor = new char[row][col];
//            int startX = 0;
//            for(int i = 0; i < row; i++) {
//                String str = scanner.nextLine();
//                if(str.contains("@")) {
//                    startX = i;
//                }
//                floor[i] = str.toCharArray();
//            }
//            int[][] book = new int[row][col];
//            Deque<Pair> queue = new LinkedList<>();
//            for(int i = 0; i < col; i++) {
//                if(floor[startX][i] == '@') {
//                    queue.offer(new Pair(startX, i));
//                    book[startX][i] = 1;
//                    break;
//                }
//            }
//
//            int count = 1;
//            while(!queue.isEmpty()) {
//                Pair pair = queue.poll();
//                for(int i = 0; i < 4; i++) {
//                    int newX = pair.x + next[i][0];
//                    int newY = pair.y + next[i][1];
//                    if(newX < 0 || newX >= row || newY < 0 || newY >= col || book[newX][newY] == 1) {
//                        continue;
//                    }
//                    if(floor[newX][newY] == '.') {
//                        queue.offer(new Pair(newX, newY));
//                        book[newX][newY] = 1;
//                        count++;
//                    }
//                }
//            }
//            System.out.println(count);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            int n = scanner.nextInt();
//            scanner.nextLine();
//            String[] paths = new String[n];
//            for(int i = 0; i < n; i++) {
//                paths[i] = scanner.nextLine();
//            }
//          Arrays.sort(paths, new Comparator<String>() {
//              @Override
//              public int compare(String o1, String o2) {
//                  int size = Math.min(o1.length(), o2.length());
//                  for (int i = 0; i < size; i++) {
//                      if(o1.charAt(i) != o2.charAt(i)) {
//                          return o1.charAt(i) - o2.charAt(i);
//                      }
//                  }
//                  return o1.length() - o2.length();
//              }
//          });
//
//            for (int i = 0; i < n - 1; i++) {
//                if(!paths[i + 1].contains(paths[i])) {
//                    System.out.println("mkdir -p " + paths[i]);
//                }
//            }
//            System.out.println("mkdir -p " + paths[n - 1]);
//        }
//        System.out.println();
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()) {
//            char[] temp = scanner.nextLine().toCharArray();
//            String name = scanner.nextLine();
//            List<String> list = new ArrayList<>();
//            StringBuilder sb = new StringBuilder();
//            boolean flag = false;
//            for(char ch : temp) {
//                if(ch == '"' && !flag) {
//                    flag = true;
//                }else if(ch == '"') {
//                    flag = false;
//                }else if(ch == ',' && !flag) {
//                    list.add(sb.toString());
//                    sb = new StringBuilder();
//                }else {
//                    sb.append(ch);
//                }
//            }
//            String ret = "Important!";
//            for(String str : list) {
//                if(str.equals(name)) {
//                    ret = "Ignore";
//                    break;
//                }
//            }
//            System.out.println(ret);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String[] str = scanner.nextLine().split("<br/>");
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0; i < str.length; i++) {
//                int num = Integer.valueOf(str[i]);
//                if(num <= 2) {
//                    sb.append(num);
//                    if(i != str.length - 1) {
//                        sb.append("<br/>");
//                    }
//                    continue;
//                }
//                int a = 1;
//                int b = 2;
//                for(int j = 3; j <= num; j++) {
//                    int temp = a + b;
//                    a = b;
//                    b = temp;
//                }
//                sb.append(num % 100_0000);
//                if(i != str.length - 1) {
//                    sb.append("<br/>");
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String[] str = scanner.nextLine().split("<br/>");
//            for(int i = 0; i < str.length; i++) {
//                List<Integer> list = new ArrayList<>();
//                int n = Integer.parseInt(str[i]);
//                int num = n;
//                for(int j = 2; j <= Math.sqrt(num); j++) {
//                    if(num % j == 0) {
//                        while(num % j == 0) {
//                            num /= j;
//                        }
//                        list.add(j);
//                    }
//
//                }
//                // 说明当前的num也是个质数了
//                if(num != 0) {
//                    list.add(num);
//                }
//                StringBuilder sb = new StringBuilder();
//                int size = list.size();
//                sb.append(n).append(" = ");
//                for(int j = 0; j < size; j++) {
//                    sb.append(list.get(j));
//                    if(j != size - 1) {
//                        sb.append(" * ");
//                    }
//                }
//                System.out.print(sb.toString());
//                if(i != str.length - 1) {
//                    System.out.println("<br/>");
//                }
//                System.out.println();
//            }
//        }
//    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str1 = scanner.nextLine();
//            String str2 = scanner.nextLine();
//            int row = str1.length();
//            int col = str2.length();
//            int[][] dp = new int[row + 1][col + 1];
//
//            for(int i = 1; i <= row; i++) {
//                dp[i][0] = i;
//            }
//            for(int i = 1; i <= col; i++) {
//                dp[0][i] = i;
//            }
//
//            for (int i = 1; i <= row; i++) {
//                for (int j = 1; j <= col; j++) {
//                    // 插入或删除
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
//                    // 替换
//                    if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
//                    }else {
//                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
//                    }
//                }
//            }
//            System.out.println(dp[row][col]);
//        }
//    }
//}

// 跳石板
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int[] dp = new int[m + 1];
//            for (int i = 0; i < dp.length; i++) {
//                dp[i] = Integer.MAX_VALUE;
//            }
//            // 初始化：第一块石板不需要移动就能到达
//            dp[n] = 0;
//            for (int i = n; i <= m; i++) {
//                // 如果当前位置保存了MAX_VALUE，说明这个位置无法到达
//                if(dp[i] == Integer.MAX_VALUE) {
//                    continue;
//                }
//                List<Integer> list = div(i);
//                for(int j : list) {
//                    if(i + j <= m) {
//                        dp[i + j] = Math.min(dp[i + j], dp[i]);
//                    }
//                }
//
//            }
//            int ret = dp[m] == Integer.MAX_VALUE ? -1 : dp[m];
//            System.out.println(ret);
//        }
//    }
//
//    private static List<Integer> div(int num) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if(num % i == 0) {
//                list.add(i);
//            }
//            if(i * i != num) {
//                list.add(num / i);
//            }
//        }
//        return list;
//    }
//
//}

// 参数解析
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            char[] ch = str.toCharArray();
//            int count = 0;
//            // 统计引号外的空格数
//            for (int i = 0; i < ch.length; i++) {
//                // 碰到双引号的时候直接跳到下一个双引号右边
//                if(ch[i] == '"') {
//                    i++;
//                    while(ch[i] != '"') {
//                        i++;
//                    }
//                    continue;
//                }
//                // 碰到空格就让计数器加一
//                if(ch[i] == ' ') {
//                    count++;
//                }
//            }
//            // 参数的个数就是空格数加一
//            System.out.println(count + 1);
//
//            // 输出参数
//            int flag = 0;
//            for (int i = 0; i < ch.length; i++) {
//                // flag为0则说明在引号外，为1则说明在引号内
//                if(ch[i] == '"') {
//                    flag ^= 1;
//                    continue;
//                }
//                if(ch[i] == ' ' && flag == 0) {
//                    // 引号外的空格，换行后跳过
//                    System.out.println();
//                    continue;
//                }
//
//                System.out.print(ch[i]);
//            }
//        }
//    }
//}

//  查找组成一个偶数最接近的两个素数
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            // 想要找到素数差值最小的素数对，就从中间开始找起
//            // 也就是分别距离n两边最近的两个素数
//            for (int i = n / 2; i < n; i++) {
//                if(isPrime(i) && isPrime(n - i)) {
//                    System.out.println(n - i);
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }
//    }
//
//    private static boolean isPrime(int n) {
//        for (int i = 2; i < Math.sqrt(n); i++) {
//            if(n % i == 0) {
//                return false;
//            }
//        }
//        return false;
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            // 位运算解决问题
//            int k = 0;
//            // 每一次消去二进制中1个连续的'1'，循环走了几次，连续的'1'就有几个
//            for(; n > 0; k++) {
//                n = n & (n << 1);
//            }
//            System.out.println(k);
//
//            // 简单解法
////            int max = 1;
////            int count = 0;
////            while(n > 0) {
////                if((n & 1) == 1) {
////                    // 说明该为是1
////                    count++;
////                    max = Math.max(max, count);
////                }else {
////                    // 该为不是1，重置count
////                    count = 0;
////                }
////                n = n >> 1;
////            }
////            System.out.println(max);
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str1 = scanner.nextLine();
//            String str2 = scanner.nextLine();
//            String ret = "";
//
//            // 始终让让str1指向较短的字符串
//                if(str1.length() > str2.length()) {
//                    String temp = str1;
//                    str1 = str2;
//                    str2 = temp;
//                }
//
//            for(int i = 0; i < str1.length(); i++) {
//                for(int j = 0; j <= i; j++) {
//                    String temp = str1.substring(j, i + 1);
//                    if(str2.contains(temp)) {
//                        ret = temp.length() > ret.length() ? temp : ret;
//                    }
//                }
//            }
//            System.out.println(ret);
//        }
//    }
//}

// 密码强度等级
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            int sum1 = lenScore(str);
//            int sum2 = letterScore(str);
//            int sum3 = numScore(str);
//            int sum4 = symbolScore(str);
//
//            int score = sum1 + sum2 + sum3 + sum4;
//            if(sum2 == 20 && sum3 > 0 && sum4 > 0) {
//                score += 5;
//            }else if(sum2 > 0 && sum3 > 0 && sum4 > 0) {
//                score += 3;
//            }else if(sum2 > 0 && sum3 > 0) {
//                score += 2;
//            }
//
//            if(score >= 90) {
//                System.out.println("VERY_SECURE");
//            }else if(score >= 80) {
//                System.out.println("SECURE");
//            }else if(score >= 70) {
//                System.out.println("VERY_STRONG");
//            }else if(score >= 60) {
//                System.out.println("STRONG");
//            }else if(score >= 50) {
//                System.out.println("AVERAGE");
//            }else if(score >= 25) {
//                System.out.println("WEAK");
//            }else {
//                System.out.println("VERY_WEAK");
//            }
//        }
//    }
//
//    private static int symbolScore(String str) {
//        char[] ch = str.toCharArray();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if(ch[i] >= 0x21 && ch[i] <= 0x2F) {
//                count++;
//            }else if(ch[i] >= 0x3A && ch[i] <= 0x40) {
//                count++;
//            }else if(ch[i] >= 0x5B && ch[i] <= 0x60) {
//                count++;
//            }else if(ch[i] >= 0x7B && ch[i] <= 0x7E) {
//                count++;
//            }
//
//            if(count == 2) {
//                return 20;
//            }
//        }
//        return count == 1 ? 10 : 0;
//    }
//
//    private static int numScore(String str) {
//        char[] ch = str.toCharArray();
//        int count = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if(ch[i] >= '0' && ch[i] <= '9') {
//                count++;
//            }
//            if(count == 2) {
//                return 20;
//            }
//        }
//        return count == 1 ? 10 : 0;
//    }
//
//    private static int letterScore(String str) {
//        char[] ch = str.toCharArray();
//        boolean lowerCase = false;
//        boolean upperCase = false;
//        for (int i = 0; i < ch.length; i++) {
//            if(!lowerCase && ch[i] >= 'a' && ch[i] <= 'z') {
//                lowerCase = true;
//            }
//            if(!upperCase && ch[i] >= 'A' && ch[i] <= 'Z') {
//                upperCase = true;
//            }
//        }
//        if(lowerCase && upperCase) {
//            return 20;
//        }else if (lowerCase || upperCase) {
//            return 10;
//        }
//        return 0;
//    }
//
//    private static int lenScore(String str) {
//        int len = str.length();
//        if(len <= 4) {
//            return 5;
//        }else if(len <= 7) {
//            return 10;
//        }else {
//            return 25;
//        }
//    }
//}

// 走方格的方案数
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int[][] dp = new int[m + 1][n + 1];
//            dp[0][0] = 1;
//            for (int i = 0; i <= m; i++) {
//                for (int j = 0; j <= n; j++) {
//                    if(i > 0) {
//                        dp[i][j] += dp[i - 1][j];
//                    }
//                    if(j > 0) {
//                        dp[i][j] += dp[i][j - 1];
//                    }
//                }
//            }
//            System.out.println(dp[m][n]);
//        }
//    }
//}

// 最小公倍数
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int mul = a * b;
//        while(b > 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        System.out.println(mul / a);
//    }
//}

// 两种排序方法
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            scanner.nextLine();
//            String[] words = new String[n];
//            for (int i = 0; i < n; i++) {
//                words[i] = scanner.nextLine();
//            }
//
//            boolean a = lexSequence(n, words);
//            boolean b = lenSequence(n, words);
//
//            if(a && b) {
//                System.out.println("both");
//            }else if(a) {
//                System.out.println("lexicographically");
//            }else if(b) {
//                System.out.println("lengths");
//            }else {
//                System.out.println("none");
//            }
//        }
//    }
//
//    private static boolean lexSequence(int n, String[] words) {
//        for (int i = 0; i < n - 1; i++) {
//            if(words[i].compareTo(words[i + 1]) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static boolean lenSequence(int n, String[] words) {
//        for (int i = 0; i < n - 1; i++) {
//            if(words[i].length() > words[i + 1].length()) {
//                return false;
//            }
//        }
//        return true;
//    }
//}

// fibonacci
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int a = 0;
//            int b = 1;
//            while(b < n) {
//                int temp = b;
//                b += a;
//                a = temp;
//            }
//            int ret = Math.min(n - a, b - n);
//            System.out.println(ret);
//        }
//    }
//}

// 连续最大和
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int n  = scanner.nextInt();
//            int[] num = new int[n];
//            for (int i = 0; i < n; i++) {
//                num[i] = scanner.nextInt();
//            }
//
//            int sum = num[0];
//            int max = num[0];
//            for (int i = 1; i < n; i++) {
//                sum = Math.max(sum + num[i], num[i]);
//                max = Math.max(max, sum);
//            }
//            System.out.println(max);
//        }
//    }
//}

// 统计回文
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String strA = scanner.nextLine();
//            String strB = scanner.nextLine();
//            int count = 0;
//            for (int i = 0; i <= strA.length(); i++) {
//                // 在当前位置插入字符串B
//                StringBuilder sb = new StringBuilder(strA);
//                sb.insert(i, strB);
//
//                // 拷贝一份然后翻转，在比较翻转之后是否相同
//                // 这里心不能直接对sb进行翻转，因为reverse是直接对字符串的修改
//                StringBuilder temp = new StringBuilder(sb);
//                temp.reverse();
//                if(temp.toString().equals(sb.toString())) {
//                    count++;
//                }
//            }
//            System.out.println(count);
//        }
//    }
//}

// 进制转换
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                'A', 'B', 'C', 'D', 'E', 'F'};
//        while(scanner.hasNextInt()) {
//            int num = scanner.nextInt();
//            if(num == 0) {
//                System.out.println(0);
//                break;
//            }
//            int n = scanner.nextInt();
//            StringBuilder sb = new StringBuilder();
//            boolean flag = false;
//            if(num < 0) {
//                flag = true;
//                num = -num;
//            }
//            while(num > 0) {
//                sb.append(ch[num % n]);
//                num /= n;
//            }
//            if(flag) {
//                sb.append("-");
//            }
//            sb.reverse();
//            System.out.println(sb.toString());
//        }
//    }
//}

// 计算糖果
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] num = new int[4];
//        while(scanner.hasNextInt()) {
//            for (int i = 0; i < 4; i++) {
//                num[i] = scanner.nextInt();
//            }
//            // 消元法
//            int a = (num[0] + num[2]) / 2;
//            int b1 = (num[2] - num[0]) / 2;
//            int b2 = (num[1] + num[3]) / 2;
//            int c = (num[3] - num[1]) / 2;
//            if(b1 == b2) {
//                System.out.println(a + " " + b1 + " " + c);
//            }else {
//                System.out.println("No");
//            }
//        }
//    }
//}

// 字符串中找出连续最长的数字串
//public class Main{
//    // 该题的核心在于利用两个String解题
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String str = scanner.nextLine();
//            int len = str.length();
//            String cur = "";
//            String ret = "";
//            int i = 0;
//            for(i = 0; i < len; i++) {
//                char ch = str.charAt(i);
//                if(ch >= '0' && ch <= '9') {
//                    // 如果当前字符是数字，那么就添加到cur中
//                    cur += ch;
//                }else {
//                    // 如果当前字符不是数字，cur与ret比较大小，如果cur大于ret，就传入引用
//                    if(cur.length() > ret.length()) {
//                        ret = cur;
//                    }
//                    // 每次碰到字符都重新开启一轮cur
//                    cur = "";
//                }
//            }
//            // 判断最后一轮cur的大小是否大于ret
//            if(i == len && cur.length() > ret.length()) {
//                ret = cur;
//            }
//            System.out.println(ret);
//        }
//    }
//}

//public class Main {
//
//    private static void reverse(char[] arr, int left, int right) {
//        while(left < right) {
//            char ch = arr[left];
//            arr[left] = arr[right];
//            arr[right] = ch;
//            left++;
//            right--;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String origin = scanner.nextLine();
//            char[] arr = origin.toCharArray();
//            int len = arr.length;
//            // 先把整个数组反转
//            reverse(arr, 0, len - 1);
//            // 然后对每一个字符串进行反转，设置两个指针
//            int i = 0;// 指向被反转字符串的起始位置
//            int j = 0;// 指向被反转字符串的末尾位置的后一个
//            while(i < len) {
//                // 让j走到字符串的末尾
//                while(j < len && arr[j] != ' ') {
//                    j++;
//                }
//                // 反转单个字符串
//                reverse(arr, i, j - 1);
//                // 让j跳过空格，此时j要么已经走到头，要么走到下个字符串的起始位置
//                j++;
//                i = j;
//            }
//            System.out.println(arr);
//        }
//    }
//
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        while(scanner.hasNextLine()) {
////            String origin = scanner.nextLine();
////            // 将字符串以" "进行分隔
////            String[] reverse = origin.split(" ");
////            // 反转字符串数组
////            int left = 0;
////            int right = reverse.length - 1;
////            while(left < right) {
////                String temp = reverse[left];
////                reverse[left] = reverse[right];
////                reverse[right] = temp;
////                left++;
////                right--;
////            }
////            StringBuilder sb = new StringBuilder();
////            for(int i = 0; i < reverse.length; i++) {
////                sb.append(reverse[i]);
////                if(i != reverse.length - 1) {
////                    sb.append(" ");
////                }
////            }
////            System.out.println(sb.toString());
////        }
////    }
//}