package ro.teamnet.zerotohero.threads_Counter;

/**
 * Created by user on 10/28/2014.
 */
public class Counter {

    public static long counter=0;
    public static synchronized void increment(){

            Counter.counter++;
            System.out.println("Val contorului este "+ Counter.counter);

            Counter.counter++;
            System.out.println("Val contorului este "+ Counter.counter);


    }
    Thread t3= new Thread();
    Thread t4= new Thread();
}
