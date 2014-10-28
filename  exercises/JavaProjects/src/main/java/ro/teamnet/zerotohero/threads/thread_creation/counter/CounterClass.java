package ro.teamnet.zerotohero.threads.thread_creation.counter;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class CounterClass {

    public static long counter = 0;

    // o functie sincron
    public synchronized void inc() {
        this.counter++;
        System.out.println(counter);
    }
}
