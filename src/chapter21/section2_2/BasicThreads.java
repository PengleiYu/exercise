package chapter21.section2_2;

import chapter21.section2_1.LiftOff;

/**
 * Created by Administrator on 2015/12/11.
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff!");
    }
}
