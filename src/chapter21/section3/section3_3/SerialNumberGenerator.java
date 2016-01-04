package chapter21.section3.section3_3;

/**
 * Created by Administrator on 2015/12/23.
 * serialNumber++在Java中是分步执行的，所以是线程不安全的
 * 加上synchronized就正常了
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
