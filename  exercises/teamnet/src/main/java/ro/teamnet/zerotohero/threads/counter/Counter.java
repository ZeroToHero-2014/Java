package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Buli on 28.10.2014.
 */
public class Counter {

    public static long counter = 0;

    public static  void increment(){
        Counter.counter++;
        System.out.println("Valoarea counterului este:" + Counter.counter);

        Counter.counter++;
        System.out.println("Valoarea counterului este:" + Counter.counter);

        Counter.counter++;
        System.out.println("Valoarea counterului este:" + Counter.counter);

        Counter.counter++;
        System.out.println("Valoarea counterului este:" + Counter.counter);

        Counter.counter++;
        System.out.println("Valoarea counterului este:" + Counter.counter);
    }

}
