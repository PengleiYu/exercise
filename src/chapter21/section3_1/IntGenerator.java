package chapter21.section3_1;

/**
 * Created by Administrator on 2015/12/21.
 * 标志位canceled为原子性，还是volatile
 * 控制程序EvenChecker的退出
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
