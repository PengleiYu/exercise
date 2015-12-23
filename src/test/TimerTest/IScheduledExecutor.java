package test.TimerTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/17.
 */
public class IScheduledExecutor {
    private ScheduledExecutorService scheduledExecutorService;
    private long tamp;

    public static void main(String[] args) {

        IScheduledExecutor executor = new IScheduledExecutor();

        executor.start1();
        executor.start2();

    }

    public IScheduledExecutor() {
        scheduledExecutorService = Executors.newScheduledThreadPool(2);
        tamp = System.currentTimeMillis();
    }

    private void start1() {
//        scheduledExecutorService.schedule(runnable1, 1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(runnable1,1,2,TimeUnit.SECONDS);
    }

    private void start2() {
        scheduledExecutorService.schedule(runnable2, 3, TimeUnit.SECONDS);
    }

    private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            long current = System.currentTimeMillis();
            System.out.println("task1 " + (current - tamp));
//            throw new RuntimeException();
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("awake");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            long current = System.currentTimeMillis();
            System.out.println("task2 " + (current - tamp));
        }
    };
}
