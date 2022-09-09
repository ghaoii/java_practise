package thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("这是 " + Thread.currentThread().getName() + " 线程");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
        }, "t1");

        Thread t2 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println("这是 " + Thread.currentThread().getName() + " 线程");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            reentrantLock.unlock();
        }, "t2");

        Thread t3 = new Thread(() -> {
            boolean isLocked = false;
            try {
                isLocked = reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS);
                if(!isLocked) {
                    System.out.println(Thread.currentThread().getName() + " 线程等不及了，准备先自己执行了");
                }
                System.out.println("这是 " + Thread.currentThread().getName() + " 线程");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(isLocked) {
                reentrantLock.unlock();
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
