package ro.teamnet.zerotohero.threads.thread_creation;

import ro.teamnet.zerotohero.threads.counter.Counter;

/**
 * Created by Buli on 28.10.2014.
 */
public class ClassThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread class extended");
    }

}
