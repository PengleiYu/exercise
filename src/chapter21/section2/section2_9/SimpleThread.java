package chapter21.section2.section2_9;

/**
 * Created by Administrator on 2015/12/11.
 * 可以通过构造器设置线程名
 * 自启动的线程
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;

    public SimpleThread() {
        super("线程"+Integer.toString(++threadCount));
        start();
    }

    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new SimpleThread();
        }
    }
}
