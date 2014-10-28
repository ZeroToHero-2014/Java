package ro.teamnet.zerotohero.thread.thread_creations;

/**
 * Created by ovy on 10/28/2014.
 */
public class ThreadTester {
    public static void main(String args[]){
        MyThread c = new MyThread();
        c.setName("threadu meu");
        c.setPriority(7);
        c.start();
        System.out.println(c);
        MyThread c1 = new MyThread();
        c1.start();
        System.out.println(c1);
    }
}
