package chapter21.section2.section2_4;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2015/12/11.
 */
public class CallableDemo {
    public static void main(String[] args) {

        ExecutorService exec= Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<>();

        for (int i=0;i<10;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs:results){
            try {
                System.out.println(fs.isDone());
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {

                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}