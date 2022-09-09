package thread.callable;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 0; i <= 500; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();
        int sum = futureTask.get();
        System.out.println(sum);

        ExecutorService pool = Executors.newCachedThreadPool();
        Future<Integer> future = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count = 0;
                for (int i = 0; i < 500; i++) {
                    count++;
                }
                return count;
            }
        });
        System.out.println(future.get());
        // 任务结束后关闭线程池
        pool.shutdown();
    }
}

//public class CallableTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        // submit的方法带有返回值
//        Future<Integer> ret = pool.submit(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int sum = 0;
//                for (int i = 1; i <= 1000; i++) {
//                    sum += i;
//                }
//                return sum;
//            }
//        });
//        // 调用get方法当前线程会阻塞，直到子线程执行结束
//        System.out.println(ret.get());
//        pool.shutdown();
//    }
//
////    public static void main(String[] args) throws ExecutionException, InterruptedException {
////        Callable<Integer> callable = new Callable() {
////            @Override
////            public Object call() throws Exception {
////                int sum = 0;
////                for (int i = 1; i <= 1000; i++) {
////                    sum += i;
////                }
////                return sum;
////            }
////        };
////        FutureTask<Integer> futureTask = new FutureTask<>(callable);
////        Thread thread = new Thread(futureTask);
////        thread.start();
////        System.out.println(futureTask.get());
////    }
//}
