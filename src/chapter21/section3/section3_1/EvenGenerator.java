package chapter21.section3.section3_1;

/**
 * Created by Administrator on 2015/12/22.
 * @title 不正确的访问资源
 * 一个任务可能在另一个任务的两次递增操作中间调用next方法，导致获得奇数，引发程序退出
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
//        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
