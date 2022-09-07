package thread;

import java.util.Random;

class Runner implements Runnable{
    private static final Random random = new Random();

    private Object lock;

    public Runner(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        int running = 9000 + random.nextInt(3000);
        try {
            Thread.sleep(running);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print(Thread.currentThread().getName() + "到达终点");
        System.out.println(", 用时 " + running / 1000.0  + "s");
        synchronized (lock) {
            // 等于2的时候只剩下主线程和垃圾回收线程
            // 等于3的时候就一定是最后一个运动员跑到终点了，此时唤醒主线程
            if(Thread.activeCount() == 3) {
                lock.notify();
            }
        }
    }
}

public class SprintThread {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runner(lock), "1号运动员");
        Thread t2 = new Thread(new Runner(lock), "2号运动员");
        Thread t3 = new Thread(new Runner(lock), "3号运动员");
        Thread t4 = new Thread(new Runner(lock), "4号运动员");
        Thread t5 = new Thread(new Runner(lock), "5号运动员");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        synchronized (lock) {
            lock.wait();
            System.out.println("所有运动员均到达终点!比赛结束!");
        }
    }
}
