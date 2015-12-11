package chapter21.section2_2;

import chapter21.section2_1.LiftOff;

/**
 * Created by Administrator on 2015/12/11.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            new Thread(new LiftOff()).start();
        System.out.println("Waiting for LiftOff!");
    }
}
