package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by George on 10/28/2014.
 */
public class Counter {
    public static long counter = 0;

    public static synchronized void increment(){
        counter++;
        System.out.println("Valoare counter: " + Counter.counter);

        counter++;
        System.out.println("Valoare counter: " + Counter.counter);
    }
}
