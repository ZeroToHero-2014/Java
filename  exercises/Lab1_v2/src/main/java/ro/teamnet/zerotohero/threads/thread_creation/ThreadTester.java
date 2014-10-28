package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Computer on 10/28/2014.
 */
public class ThreadTester {
    public static void main (String[] args)
    {
        ExtendThread t1= new ExtendThread();
        Thread t2 = new Thread(new ImplementRunnable());

        t1.start();
        t1.setPriority(2);
        t1.setName("Thread 1");
        System.out.println(t1);

        t2.start();
        t2.setPriority(4);
        t2.setName("Thread 2");
        System.out.println(t2);


    }

}
