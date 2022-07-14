package thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num = new AtomicInteger();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                num.incrementAndGet();
            }
        });
        thread.start();
        for (int i = 0; i < 1000; i++) {
            num.incrementAndGet();
        }
        thread.join();
        System.out.println(num.get());
    }
}
