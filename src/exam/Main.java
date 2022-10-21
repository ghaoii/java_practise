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
    private static int[][] next = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        Pair start = new Pair(0, 0);
        Deque<List<Pair>> queue = new LinkedList<>();
        List<Pair> list = new ArrayList<>();
        list.add(start);
        queue.offer(list);
        int[][] book = new int[row][col];
        book[0][0] = 1;
        List<Pair> ret = null;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                list = queue.poll();
                Pair cur = list.get(list.size() - 1);
                if(cur.x == row - 1 && cur.y == col - 1) {
                    ret = list;
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = cur.x + next[j][0];
                    int newY = cur.y + next[j][1];
                    if(newX < 0 || newX >= row || newY < 0 || newY >= col ||
                            book[newX][newY] == 1 || arr[newX][newY] == 1) {
                        continue;
                    }
                    Pair pair = new Pair(newX, newY);
                    List<Pair> temp = new ArrayList<>(list);
                    temp.add(pair);
                    queue.offer(temp);
                    book[newX][newY] = 1;
                }
            }
            if(ret != null) {
                break;
            }
        }
        for(Pair pair : ret) {
            System.out.println("(" + pair.x + "," + pair.y + ")");
        }
    }
}