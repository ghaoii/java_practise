package thread;

public class CreateThread {
    public static void main(String[] args) {
        // 1. 继承Thread类
        class MyThraed extends Thread {
            @Override
            public void run() {
                System.out.println("继承Thread线程实现");
            }
        }
        Thread t1 = new MyThraed();
        t1.start();

        // 2. 实现Runnable接口
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("实现Runnable接口");
            }
        }
        MyRunnable mb = new MyRunnable();
        Thread t2 = new Thread(mb);
        t2.start();

        // 3. 匿名内部类实现Runnable接口
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现Runnable接口");
            }
        });
        t3.start();

        // 4. 匿名内部类继承Thread实现
        Thread t4 = new Thread() {
            @Override
            public void run() {
                System.out.println("匿名内部类继承Thread类实现");
            }
        };
        t4.start();

        // 5. Lambda表达式实现
        Thread t5 = new Thread(() -> {
            System.out.println("Lambda表达式实现");
        });
        t5.start();
    }
}
