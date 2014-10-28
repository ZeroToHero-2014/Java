package ro.teamnet.zerotohero.threads.thread_creation;
import ro.teamnet.zerotohero.threads.thread_creation.Thread1;


/**
 * Created by user on 10/28/2014.
 */
public class ThreadTester {
    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Runnable t2 = new Thread2();

        t1.run();
        System.out.println("\n");
        t2.run();

        System.out.println("Thread with default priority:"+t1);
        System.out.println("\n");
        t1.setPriority(8);
        t1.setName("NewThreadName");
        System.out.println("Thread with new priority and name:"+t1);
    }

}
