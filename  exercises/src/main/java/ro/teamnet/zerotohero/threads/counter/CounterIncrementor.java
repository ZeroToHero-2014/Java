package ro.teamnet.zerotohero.threads.counter;

/**
 * Created by Juvie on 28.10.2014.
 */
public class CounterIncrementor {
    public static void main(String[] args) {
        final CounterClass cc = new CounterClass();
        Thread t = new Thread() {
            public void run() {
//                CounterClass.counter++;
//                System.out.println(CounterClass.counter);
//                CounterClass.counter++;
//                System.out.println(CounterClass.counter);
                cc.increment();
                cc.increment();

            }
        };
        Thread t1 = new Thread() {
            public void run() {
//                CounterClass.counter++;
//                System.out.println(CounterClass.counter);
//                CounterClass.counter++;
//                System.out.println(CounterClass.counter);
                cc.increment();
                cc.increment();
            }
        };
        t1.start();
        t.start();
    }
}
