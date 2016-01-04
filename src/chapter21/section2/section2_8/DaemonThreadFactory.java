package chapter21.section2.section2_8;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2015/12/11.
 * 线程工厂将生产的线程设为后台线程
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
