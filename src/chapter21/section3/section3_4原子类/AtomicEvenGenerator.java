package chapter21.section3.section3_4原子类;

import chapter21.section3.section3_1.EvenChecker;
import chapter21.section3.section3_1.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2015/12/25.
 * 用原子类重写MutexEvenGenerator
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue = new AtomicInteger(0);

    @Override
    public int next() {
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
