package chapter21.section3_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/12/21.
 * 创建大量线程
 * 检测到非偶数则修改IntGenerator的标志位，使所有线程退出
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press Ctr-C to exit");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new EvenChecker(generator, count));
        }
        service.shutdown();
    }


    public static void test(IntGenerator generator) {
        test(generator, 10);
    }

    @Override
    public void run() {

        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }

            if (val % 10000 == 0)
                System.out.println("alive");
        }
    }
}
