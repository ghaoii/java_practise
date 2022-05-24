package queue.impl;

public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue(6);
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
