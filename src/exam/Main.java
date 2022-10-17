package exam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                if(queue.peekFirst() > queue.peekLast()) {
                    list.add(queue.pollFirst());
                }else {
                    list.add(queue.pollLast());
                }
            }else {
                if(queue.peekFirst() < queue.peekLast()) {
                    list.add(queue.pollFirst());
                }else {
                    list.add(queue.pollLast());
                }
            }
        }
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}