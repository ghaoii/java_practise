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
                     System.out.println(ch + " - " + i);
                 }
                 state++;
                 LOCK.notifyAll();
            }
        }
    }
}
