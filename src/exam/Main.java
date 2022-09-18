package exam;

import java.util.*;

class Stone {
    int left;
    int center;
    int right;

    public Stone(int left, int center, int right) {
        this.left = left;
        this.center = center;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<List<Stone>> list = new ArrayList<>();
            int count = 0;
            for(int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                List<Stone> stones = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int left = scanner.nextInt();
                    Stone stone = new Stone(left, left + 50, left + 100);
                    if(i == 0) {
                        stones.add(stone);
                        count++;
                    }else if(notBreak(list.get(i - 1), left, left + 50, left + 100)) {
                        stones.add(stone);
                        count++;
                    }
                }
                list.add(stones);
            }
            System.out.println(count);
        }
    }

    private static boolean notBreak(List<Stone> stones, int left, int center, int right) {
        int flagA = 0;
        for(Stone stone : stones) {
            if(right < stone.left) {
                break;
            }
            if(left > stone.right) {
                continue;
            }
            if(left == stone.left) {
                return true;
            }
            if(right > stone.left && right < stone.right) {
                if(center > stone.left) {
                    return true;
                }
                flagA++;
            }else if(left > stone.left && left < stone.right) {
                if(center < stone.right) {
                    return true;
                }
                flagA++;
            }
            if(flagA == 2) {
                return true;
            }

        }
        return false;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            String[] strs = scanner.nextLine().split(" ");
//            if(strs.length < 5 || strs.length % 5 != 0) {
//                System.out.println(false);
//                continue;
//            }
//            Map<String, Integer> map = new HashMap<>();
//            for(String str : strs) {
//                map.put(str, map.getOrDefault(str, 0) + 1);
//            }
//
//            boolean flag = true;
//            for(Map.Entry<String, Integer> entry : map.entrySet()) {
//                if(entry.getValue() != 5) {
//                    flag = false;
//                    break;
//                }
//            }
//            System.out.println(flag);
//        }
//    }
}
