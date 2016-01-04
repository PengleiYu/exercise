package chapter21.section3.section3_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/12/23.
 * 非原子性
 * getValue()有可能在两次递增之间获取值，正确做法加上synchronized
 * 类似return i++;的语句也是线程不安全的，因为java在执行i++时会产生get和put指令，分为几步来执行
 * 应该i++; return i;
 * volatile只是指示编译器该变量会被多线程读写，但并不能避免非原子性
 */
public class AtomicityTest implements Runnable {
    private volatile int i = 0;

    public int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
