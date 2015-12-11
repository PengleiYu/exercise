package chapter21.section2_9;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/12/11.
 */
public class ThreadVariations {
    public static void main(String[] args) {

    }
}

//内部类
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(this);
                if (countDown-- == 0) {
                    return;
                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return getName() + ":" + countDown;
        }
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                while (true) {
                    System.out.println(this);
                    if (countDown-- == 0) {
                        return;
                    }
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public String toString() {
                return getName() + ":" + countDown;
            }
        };
        t.start();
    }
}

class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(this);
                if (countDown-- == 0) {
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return t.getName() + ":" + countDown;
        }
    }
}

class InnerRunnable2{

}