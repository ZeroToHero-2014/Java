package ro.teamnet.zerotohero.threads.Counter;


public class Counter {


    public static long counter=0;

    public static void syncronize (){
        Counter.counter++;
        System.out.println("Valoarea counterului este "+Counter.counter);
        Counter.counter++;
        System.out.println("Valoarea counterului este "+Counter.counter);
        Counter.counter++;
        System.out.println("Valoarea counterului este "+Counter.counter);
        Counter.counter++;
        System.out.println("Valoarea counterului este "+Counter.counter);
    }



}
