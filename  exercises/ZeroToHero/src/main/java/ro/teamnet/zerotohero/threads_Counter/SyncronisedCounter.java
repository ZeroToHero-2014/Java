package ro.teamnet.zerotohero.threads_Counter;

/**
 * Created by user on 10/28/2014.
 */
public class SyncronisedCounter {
    public static void main(String []args){
        Thread t= new Thread(){

            public void run(){

                Counter.increment();
                //System.out.println("Val contorului este "+ Counter.counter);

                Counter.increment();
                //System.out.println("Val contorului este "+ Counter.counter);

            }


        };
        Thread t2= new Thread(){

            public void run(){
                Counter.increment();
                //System.out.println("Val contorului este "+ Counter.counter);

                Counter.increment();
                //System.out.println("Val contorului este "+ Counter.counter);

            }


        };
        t.start();
        t2.start();
    }

}
