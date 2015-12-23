package chapter21.section3_2;

import chapter21.section3_1.EvenChecker;
import chapter21.section3_1.IntGenerator;


/**
 * Created by Administrator on 2015/12/22.
 * synchronized关键字
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {

        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
