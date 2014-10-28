package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Ifrim on 28.10.2014.
 */
public class ThreadTester {
    public static void main(String[] args) {
        MyFirstThread t = new MyFirstThread();
        t.setName("MyFirstThread");
        t.setPriority(8);
        t.start();
        System.out.println(t);
}
}
