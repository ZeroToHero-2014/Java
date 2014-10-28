package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by user on 10/28/2014.
 */
public class Counter {
    public static long count = 0;

    public static synchronized void increment(){
        Counter.count++;
        System.out.println("Count value is:"+Counter.count);
        Counter.count++;
        System.out.println("Count value is:"+Counter.count);
    }


}
