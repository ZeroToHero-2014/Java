package ro.teamnet.zerotohero.threads.counter;

public class CounterIncrementor extends Thread {
    public static void main(String[] args) {
        final CounterClass cc = new CounterClass();
        Thread t = new Thread(){
            public void run(){
                cc.increment();
                cc.increment();
            }
        };

        Thread t1 = new Thread(){
            public void run(){
                cc.increment();
                cc.increment();
            }
        };

        t.start();
        t1.start();
    }
}
