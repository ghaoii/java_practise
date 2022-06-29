package thread.threadpool;

import java.util.concurrent.*;

public class DiscardPolicyTest {
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(100);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService pool = new ThreadPoolExecutor(5
                , 10
                , 0
                , TimeUnit.SECONDS
                , queue
                , handler);

        // 写法二
//        class Task implements Runnable {
//            int num;
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + "正在执行任务" + num);
//            }
//
//            public Task(int num) {
//                this.num = num;
//            }
//        }
//        for (int i = 0; i < 200; i++) {
//            pool.submit(new Task(i));
//        }

        // 写法一
        for (int i = 0; i < 200; i++) {
            // 方法内部类中调用成员变量必须是隐式的final修饰，由于i需要变化，因此单独创建一个num变量
            final int num = i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务" + num);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
    }

}
