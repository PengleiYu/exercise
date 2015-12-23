package test.TimerTest;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/17.
 */
public class ITimer {
    private TimerTask task;
    private Timer timer = new Timer();
    private long tamp = System.currentTimeMillis();
    private Random random = new Random();

    public static void main(String[] args) {

        ITimer timer = new ITimer();
        timer.start();

    }

    public void start() {
        cancel();
        if (timer == null)
            timer = new Timer();
        if (task == null)
            task = new TimerTask() {
                @Override
                public void run() {
                    long current = System.currentTimeMillis();
                    System.out.println("Hello! " + (current - tamp));
                    System.out.println("启动时间:" + (this.scheduledExecutionTime() - tamp));
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
//        timer.scheduleAtFixedRate(task, 500, 2000);
        timer.scheduleAtFixedRate(task, 500, 2000);
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (task != null) {
            task.cancel();
            task = null;
        }
    }

    private TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            long current = System.currentTimeMillis();
            System.out.println("task1 " + (current - tamp));
//            throw new RuntimeException();

        }
    };
    private TimerTask task2 = new TimerTask() {
        @Override
        public void run() {
            long current = System.currentTimeMillis();
            System.out.println("task2 " + (current - tamp));
        }
    };

}
