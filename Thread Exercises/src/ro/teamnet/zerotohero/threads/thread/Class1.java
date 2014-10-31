package ro.teamnet.zerotohero.threads.thread;

/**
 * Created by Andrei on 10/30/2014.
 */
class Counter {
    public static long count = 0;
}

public class Class1 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread Class1");
        increment();
        increment();
        increment();
    }
    // declaring the increment synchronized instead of using
    // a synchronized statement for a block of code inside the method
    public synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

}
