package Threads.ThreadsCreation.Creation;

import Threads.ThreadsCreation.Creation.MyFirstThread;

/**
 * Created by andrei.dobre on 28.10.2014.
 */
public class ThreadTester {

    public static void main(String arg[])
    {
        MyFirstThread a = new MyFirstThread();

        a.setName("MyFirstThread");
        a.setPriority(3);

        System.out.println(a);

        a.start();
    }
}
