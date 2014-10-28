package ro.teamnet.zerotohero.threads.thread_creation.Counter;

/**
 * Created by Computer on 10/28/2014.
 */
public class Counter {

    public static long counter=0;
    public static synchronized void increment()
    {
        Counter.counter++;
        System.out.println("Valoarea counterului este " + Counter.counter);
        Counter.counter++;
        System.out.println("Valoarea counterului este " + Counter.counter);
    }

}
