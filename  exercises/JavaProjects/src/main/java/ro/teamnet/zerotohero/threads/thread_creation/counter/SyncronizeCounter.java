package ro.teamnet.zerotohero.threads.thread_creation.counter;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class SyncronizeCounter {

    public static void main(String[] args) {

        final CounterClass cc = new CounterClass();

        Thread th = new Thread() {
            public void run() {
                cc.inc();
                cc.inc();
            }
        };
        Thread th1 = new Thread() {
            public void run() {
                cc.inc();
                cc.inc();
            }
        };

        th.start();
        th1.start();
    }
}