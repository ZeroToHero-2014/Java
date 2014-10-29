package ro.teamnet.zerotohero.threads.thread_creation;

import ro.teamnet.zerotohero.exceptions.MyException;

/**
 * Created by Bogdan on 10/28/2014.
 */
public class ThreadTester
{
    public static void main(String[] args)
    {
        MyFirstThread myThread = new MyFirstThread();
        myThread.setName("myThread");
        myThread.setPriority(8);
        myThread.start();
        System.out.println(myThread);
    }
}
