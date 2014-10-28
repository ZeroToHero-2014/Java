package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by user on 10/28/2014.
 */
public class SynchronizedCounter {




    public static void main(String[] args){
        Thread myThread= new Thread(){
            public void run(){
               Counter.increment();
               Counter.increment();


            }
        };

        Thread myThread_2= new Thread(){
            public void run(){
                Counter.increment();
                Counter.increment();
                Counter.increment();
            }
        };

        myThread.start();
        myThread_2.start();


    }
}
