package ro.teamnet.zerotohero.threads.thread_creation;


public class ThreadTester {

    public static void main(String[] args) {

        Thread t1= new Thread(new Class2());


        Class1 t2 = new Class1();


        System.out.println(t1);

        t1.setName("Primul thread!");
        t1.setPriority(2);

        System.out.println(t1);
        t1.start();
        t2.start();
    }

}
