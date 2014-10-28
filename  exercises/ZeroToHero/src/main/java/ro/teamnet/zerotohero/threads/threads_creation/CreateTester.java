package ro.teamnet.zerotohero.threads.threads_creation;

import sun.awt.windows.ThemeReader;

/**
 * Created by user on 10/28/2014.
 */
public class CreateTester {

    public static void main(String[]args){
        ExtendsThread t1= new ExtendsThread();
        Thread t2= new Thread(new ImplementRunnable());



        System.out.println(t1);
        t1.setPriority(10);
        System.out.println(t1);
        t1.setName("Thread1");
        System.out.println(t1);
        t1.start();
        t2.start();
    }

}
