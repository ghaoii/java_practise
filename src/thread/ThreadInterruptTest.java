package thread;

import test.MyTest;

public class ThreadInterruptTest {
//    private static class MyRun implements Runnable{
//        @Override
//        public void run() {
//            //如果线程没有中断，就执行循环
//            while(!Thread.interrupted()) {
//                System.out.println(Thread.currentThread().getName() + "Lana Del Ray的歌百听不厌");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    System.err.println("可是Dua Lipa的歌也很好听哇～");
//                    break;
//                }
//            }
//        }
//    }

    private static class MyRun implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                //System.out.println(Thread.interrupted());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRun myRun = new MyRun();
        Thread thread = new Thread(myRun, "音乐鉴赏");
        thread.start();
        thread.interrupt();
    }
}
