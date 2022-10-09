package exam;

import java.util.*;


class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int q = scanner.nextInt();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            List<Pair> temp = new ArrayList<>();
            if(list.isEmpty()) {
                list.add(new Pair(left, right));
                continue;
            }
            for(Pair pair : list) {
                if(left > pair.right && right < pair.right) {
                    temp.add(new Pair(left, pair.left - 1));
                    temp.add(new Pair(pair.right + 1, right));
                }else if(left > pair.right || right < pair.right) {
                    temp.add(new Pair(left, right));
                    temp.add(pair);
                } else {
                    if(left > pair.left) {
                        temp.add(new Pair(pair.left, left - 1));
                    }
                    if(right < pair.right) {
                        temp.add(new Pair(right + 1, pair.right));
                    }
                }
            }
            list = temp;
        }
        for(Pair pair : list) {
            n -= pair.right - pair.left + 1;
        }
        System.out.println(n);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] river = new int[n];
//        for (int i = 0; i < n; i++) {
//            river[i] = scanner.nextInt();
//        }
//        int max = 0;
//        Map<Integer, Integer> leftMap = new HashMap<>();
//        Map<Integer, Integer> rightMap = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int water = leftSlow(river, i, leftMap) + rightSlow(river, i, rightMap) + 1;
//            max = Math.max(max, water);
//        }
//        System.out.println(max);
//    }
//
//    private static int leftSlow(int[] river,int cur, Map<Integer, Integer> map) {
//        if(cur == 0) {
//            return 0;
//        }
//        if(map.containsKey(cur)) {
//            return map.get(cur);
//        }
//        int water = 0;
//        if(river[cur - 1] < river[cur]) {
//            water = 1 + leftSlow(river,cur - 1, map);
//        }
//        map.put(cur, water);
//        return water;
//    }
//
//    private static int rightSlow(int[] river, int cur, Map<Integer, Integer> map) {
//        if(cur == river.length - 1) {
//            return 0;
//        }
//        if(map.containsKey(cur)) {
//            return map.get(cur);
//        }
//        int water = 0;
//        if(river[cur + 1] < river[cur]) {
//            water = 1 + leftSlow(river,cur + 1, map);
//        }
//        map.put(cur, water);
//        return water;
//    }
//}