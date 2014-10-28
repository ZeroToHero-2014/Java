package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by George on 10/28/2014.
 */
public class SynchronizeCounter {
    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run(){
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };


        Thread t2 = new Thread(){
            @Override
            public void run(){
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };

        t1.start();
        t2.start();
    }
}
