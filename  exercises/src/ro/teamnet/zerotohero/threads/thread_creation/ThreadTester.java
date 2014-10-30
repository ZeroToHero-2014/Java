package ro.teamnet.zerotohero.threads.thread_creation;

public class ThreadTester {

    public static void main(String[] args){
        MyFirstThread t=new MyFirstThread();
        t.setName("my first thread");
        t.setPriority(3);
        t.start();
        System.out.println(t);
    }

}
