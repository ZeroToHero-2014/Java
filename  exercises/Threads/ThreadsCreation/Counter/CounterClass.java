package Threads.ThreadsCreation.Counter;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class CounterClass {
    public static long counter = 0;

    public  synchronized void increment(){
        counter++;
        System.out.println("Counter: " + counter);
    }

}
