package chapter21.section2.section2_12;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/12/21.
 * 创建有响应的用户界面
 */
public class ResponsiveUI extends Thread {

    public static void main(String[] args) throws IOException {
//        new UnresponsiveUI();

//可交互，计算是后台进程，所以输入完后，程序运行结束

        new ResponsiveUI();
//        System.out.println(new Scanner(System.in).nextLine());
        System.in.read();
        System.out.println(d);
    }

    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
    }
}
//不能交互，输入字符后无反映，程序不结束
class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws IOException {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.out.println(new Scanner(System.in).nextLine());
    }
}