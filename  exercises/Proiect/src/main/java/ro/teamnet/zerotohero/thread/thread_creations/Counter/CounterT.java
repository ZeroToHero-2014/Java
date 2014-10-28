package ro.teamnet.zerotohero.thread.thread_creations.Counter;

/**
 * Created by ovy on 10/28/2014.
 */
public class CounterT {
    public static long counter=0;
    public synchronized void sy(){
        counter++;
        System.out.println(counter);
   }
}
