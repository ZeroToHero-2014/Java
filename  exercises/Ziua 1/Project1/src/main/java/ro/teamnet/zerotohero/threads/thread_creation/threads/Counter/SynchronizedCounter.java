package ro.teamnet.zerotohero.threads.thread_creation.threads.Counter;

/**
 * Created by user on 10/27/2014.
 */
public class SynchronizedCounter {

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {

//                synchronized { Counter.counter++;};
                Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();

            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
               Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };

        t1.start();
        t2.start();


    }


}
