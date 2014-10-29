package ro.teamnet.zerotohero.threads.thread_creation.threads.Counter;

/**
 * Created by user on 10/27/2014.
 */
public class Counter {

    public static long counter =0 ;


    public synchronized static void increment() {
        Counter.counter++;
        System.out.println("Valoarea counter-ului este " + Counter.counter);

    }
}
