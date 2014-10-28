package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Miha on 10/28/2014.
 */
public class SycronizedCounter {
    public static void main(String[] args) {
        final CounterClass cc = new CounterClass();
        Thread t1 = new Thread(){
            public void run(){
                //CounterClass.counter++;
                //System.out.println("Counterul are valoarea " + CounterClass.counter);
                //CounterClass.counter++;
                //System.out.println("Counterul are valoarea " + CounterClass.counter);
                cc.increment();
                cc.increment();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                //CounterClass.counter++;
                //System.out.println("Counterul are valoarea " + CounterClass.counter);
                //CounterClass.counter++;
                //System.out.println("Counterul are valoarea " + CounterClass.counter);
                cc.increment();
                cc.increment();
            }
        };
        t1.start();
        t2.start();
    }
}
