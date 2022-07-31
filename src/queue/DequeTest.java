package queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
//        queue.offer(10);
//        queue.offer(20);
//        queue.offer(30);
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.offer(40);
        System.out.println(queue.peekLast());
//        System.out.println(queue.poll());
        System.out.println(queue.pop());
    }
}
