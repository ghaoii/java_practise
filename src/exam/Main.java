package exam;
import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
//
//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
    @Override
    public boolean equals(Object obj) {
        Pair pair = (Pair) obj;
        return this.x == pair.x && this.y == pair.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        Set<Pair> set = new HashSet<>();
        int maxX = -1;
        int maxY = -1;
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            Pair pair = new Pair(x, y);
            if(set.contains(pair)) {
                continue;
            }
            set.add(pair);
            mapX.put(x, mapX.getOrDefault(x, 0) + 1);
            if(maxX == -1 || mapX.get(x) > mapX.get(maxX)) {
                maxX = x;
            }
            mapY.put(y,mapY.getOrDefault(y, 0) + 1);
            if(maxY == -1 || mapY.get(y) > mapY.get(maxY)) {
                maxY = y;
            }
        }
        int count = mapX.get(maxX) + mapY.get(maxY);
        for(Pair pair : set) {
            if(pair.x == maxX && pair.y == maxY) {
                count--;
                break;
            }
        }
        System.out.println(count);
    }
}