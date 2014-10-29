package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class CounterClass
{
    public static long counter = 0;

    public synchronized void increment()
    {
        counter++;
        System.out.println(counter);
    }
}
