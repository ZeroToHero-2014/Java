package ro.teamnet.zerotohero.threads.Counter;


public class SyncronizeCounter {

    public static void main(String[] args) {

        Thread t = new Thread() {

            public void run() {
                Counter.syncronize();
                Counter.syncronize();
                Counter.syncronize();
            }
        };

        Thread t1 = new Thread() {

            public void run() {
                Counter.syncronize();
                Counter.syncronize();
                Counter.syncronize();
            }
        };

        t.start();
        t1.start();

    }
}
