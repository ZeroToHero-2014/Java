package ro.teamnet.zerotohero.threads.thread_creation;

/**
 * Created by Miha on 10/28/2014.
 */
public class ThreadTester {
    public static void main(String[] args) {
        MyFirstThread thread1 = new MyFirstThread();
        thread1.setName("MyDearThread");
        thread1.setPriority(10);
        thread1.start();
        System.out.println(thread1);  //ne afiseaza numele, prioritatea si threadul parinte al thread1
    }
}
