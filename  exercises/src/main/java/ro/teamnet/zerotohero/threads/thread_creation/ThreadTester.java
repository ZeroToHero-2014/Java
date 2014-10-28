package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Juvie on 28.10.2014.
 */
public class ThreadTester {
    public static void main(String[] args) {
        FirstThread ft = new FirstThread();
        ft.setName("My first thread");
        ft.setPriority(10);
        ft.start();
        System.out.println(ft);
    }
}
