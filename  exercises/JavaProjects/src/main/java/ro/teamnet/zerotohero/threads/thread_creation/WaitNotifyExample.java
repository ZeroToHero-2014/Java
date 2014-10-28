package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Dumitru on 28.10.2014.
 */
public class WaitNotifyExample {

    public static void main(String[] args) {
        Calculate th = new Calculate();
        th.start();

        synchronized (th) {
            try {
                System.out.println("Waiting for th to complete...");
                th.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total is: " + th.total);
        }
    }
}

class Calculate extends Thread {
    int total;

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                total += i;
            }
            notify();
        }
    }
}
