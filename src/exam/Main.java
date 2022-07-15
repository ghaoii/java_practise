package exam;

import java.util.*;

// 连续最大和
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n  = scanner.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = scanner.nextInt();
            }

            int sum = num[0];
            int max = num[0];
            for (int i = 1; i < n; i++) {
                sum = Math.max(sum + num[i], num[i]);
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
    }
}

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