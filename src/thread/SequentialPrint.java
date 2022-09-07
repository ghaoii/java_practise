package thread;

public class SequentialPrint {
    private static final Object LOCK = new Object();
    private static int state = 0;

    public static void main(String[] args) {
        Thread printA = new Thread(() -> {
           printABC('A', 0);
        });
        Thread printB = new Thread(() -> {
            printABC('B', 1);
        });
        Thread printC = new Thread(() -> {
            printABC('C', 2);
        });
        printA.start();
        printB.start();
        printC.start();
    }

    private static void printABC(char ch, int targetState) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                // 判断一下是不是轮到自己打印了，不是的话唤醒其他线程
                // 不能使用if来判断，否则唤醒之后就直接打印了，我们需要在唤醒之后再次判断是不是轮到自己了
                while(state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                 if(targetState != 2) {
                     System.out.print(ch);
                 }else {
                     // 打印C之后记录一下是第几个ABC，没别的意思，这里去掉if-else直接打印也没问题
                     System.out.println(ch + " - " + i);
                 }
                 state++;
                 LOCK.notifyAll();
            }
        }
    }
}
