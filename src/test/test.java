package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2015/12/24.
 */
public class test {
    public static Thread thread;
    public static boolean run;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);
//        Calendar calendar=Calendar.getInstance();
//        calendar.set(3000,1,1);


//        String date=format.format(new Date(1451268610000L));
//        System.out.println(date);
//        System.out.println(new Date().getTime());

//        DateFormat format=DateFormat.getDateTimeInstance();
//        System.out.println(format.format(new Date()));

//        ExecutorService service=Executors.newCachedThreadPool();
//        Future<?> future=service.submit(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("haha");
//            }
//        });
//        System.out.println(future.get());

//
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println(reader.readLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//

    }

    public static void start() {
        cancel();
        run = true;
        if (thread == null)
            thread = new Thread() {
                @Override
                public void run() {
                    while (run) {
                        System.out.println("hello");
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
        thread.start();
    }

    public static void cancel() {
        run = false;
        if (thread != null) {
            thread.interrupt();
        }
    }
}

