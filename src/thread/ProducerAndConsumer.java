package thread;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {


    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        Random random = new Random();

        Thread producer = new Thread(() -> {
            while(true) {
                try {
                    int val = random.nextInt(100) + 1;
                    blockingQueue.put(val);
                    System.out.println("生产元素价值: " + val);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "生产者");
        producer.start();

        Thread consumer  = new Thread(() -> {
            while(true) {
                int val = 0;
                try {
                    val = blockingQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("消费元素价值: " + val);
            }
        }, "消费者");
        consumer.start();

    }
}
