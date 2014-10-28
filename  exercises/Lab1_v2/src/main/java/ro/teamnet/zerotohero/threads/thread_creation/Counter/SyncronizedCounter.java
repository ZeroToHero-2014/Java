package ro.teamnet.zerotohero.threads.thread_creation.Counter;

/**
 * Created by Computer on 10/28/2014.
 */
public class SyncronizedCounter
{

    public static void main (String[] args)
    {
        Thread t1 = new Thread()
        {
            public void run()
            {
                Counter.increment();
                //Counter.counter++;
               // System.out.println("Valoarea counterului este " + Counter.counter++);
                //Counter.counter++;
               //System.out.println("Valoarea counterului este " + Counter.counter++);
            }

        };
        Thread t2 = new Thread() {
            public void run() {
               // Counter.counter++;
               // System.out.println("Valoarea counterului este " + Counter.counter++);
                //Counter.counter++;
                //System.out.println("Valoarea counterului este " + Counter.counter++);
                Counter.increment();
            }
        };
        t1.start();
        t2.start();
    }
}
