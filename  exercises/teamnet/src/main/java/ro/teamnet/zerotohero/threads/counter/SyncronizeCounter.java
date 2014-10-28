package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Buli on 28.10.2014.
 */
public class SyncronizeCounter {

    public static void main(String[] Args){

        Thread t = new Thread(){
            @Override
        public void run(){
                Counter.increment();
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
                Counter.increment();
            }
        };

        t.start();
        t2.start();
    }

}
