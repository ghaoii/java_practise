package thread.timer;

import org.omg.CORBA.TIMEOUT;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", 3s之后再执行任务");
            }
        }, 3000, 1000);
    }
}
