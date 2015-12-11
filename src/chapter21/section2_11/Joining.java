package chapter21.section2_11;

/**
 * Created by Administrator on 2015/12/11.
 */
public class Joining {


    public static void main(String[] args) {


        Sleeper sleepy=new Sleeper("Sleepy",1500), grumpy=new Sleeper("Grumpy",1500);
        Joiner dopey=new Joiner("Dopey",sleepy),doc=new Joiner("Doc",grumpy);
        grumpy.interrupt();
    }
}

class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" join completed!");
    }
}

class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name,int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName()+" has awakened!");
    }
}
