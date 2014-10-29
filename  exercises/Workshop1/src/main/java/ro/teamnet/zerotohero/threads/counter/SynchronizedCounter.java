package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class SynchronizedCounter
{
    public static void main(String[] args)
    {
        final CounterClass cc = new CounterClass();
        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                cc.increment();
                cc.increment();
            }
        };

        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                cc.increment();
                cc.increment();
            }
        };
        t.start();
        t1.start();


    }
}
