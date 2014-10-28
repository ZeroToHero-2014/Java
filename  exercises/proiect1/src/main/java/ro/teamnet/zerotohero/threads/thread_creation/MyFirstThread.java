package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Miha on 10/28/2014.
 */
public class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("In run method!");
    }
}
