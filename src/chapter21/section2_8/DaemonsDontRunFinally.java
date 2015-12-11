package chapter21.section2_8;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/11.
 * 前台线程关闭，后台线程尽管有finally也来不及执行
 */
class ADaemon implements Runnable {
    @Override
    public void run() {
        System.out.println("starting ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            System.out.println("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
