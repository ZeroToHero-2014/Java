package ro.teamnet.zerotohero.threads.thread_creation;

import com.sun.media.sound.EmergencySoundbank;

/**
 * Created by Buli on 28.10.2014.
 */
public class ThreadTester {

    public static void main (String[] Args){
        ThreadTester myThread = new ThreadTester();

        Thread newThread = new ClassThread();
        newThread.run();

        System.out.println("newThread priority:" + newThread.getPriority());
        System.out.println("newThread name:" + newThread.getName());

        newThread.setPriority(10);
        newThread.setName("Exercise 3");

        System.out.println("newThread priority:" + newThread.getPriority());
        System.out.println("newThread name:" + newThread.getName());
    }

}
