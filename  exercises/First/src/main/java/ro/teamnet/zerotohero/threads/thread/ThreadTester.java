package ro.teamnet.zerotohero.threads.thread;

/**
 * Created by George on 10/28/2014.
 */
public class ThreadTester {

    public static void main(String[] args) {

        ThreadImplement t0 = new ThreadImplement();
        t0.run();

        Thread t1 = new ThreadExtends();

        System.out.println("Name: " + t1.getName() + " == Priority " +t1.getPriority());
        t1.setName("aaa");
        t1.setPriority(10);
        System.out.println("Name: " + t1.getName() + " == Priority " +t1.getPriority());


        t1.start();
    }



}
