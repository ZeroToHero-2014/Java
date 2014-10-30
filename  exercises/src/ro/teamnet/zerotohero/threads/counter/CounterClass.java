package ro.teamnet.zerotohero.threads.counter;

public class CounterClass {

    public static long counter=0;

    public synchronized void  increment(){
        counter++;
        System.out.println(counter);
    }

}
